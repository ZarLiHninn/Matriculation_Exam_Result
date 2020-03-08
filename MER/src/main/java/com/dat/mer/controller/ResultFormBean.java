package com.dat.mer.controller;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dat.mer.model.ResultModel;
import com.dat.mer.services.ResultManagementService;

@Controller
@RequestMapping("/LGN002")
public class ResultFormBean {
	@Autowired
	private ResultManagementService service;
	@RequestMapping("/MGT003")
	public String load(Model model,HttpSession session){
		if(session.getAttribute("password_id")!=null){
			model.addAttribute("resultModel",new ResultModel());
			service.SetButtonText("Add");
			service.initialload(model);
			service.SetNotificationMessage("");
			service.SetStudentInfoForUpdate("");
			return "MGT003";
		}
		else {
			return "error";
		}
			
	}
	@RequestMapping("/selectedyear/{year}")
	@ResponseBody
	public List<String> getYearByRollno(@PathVariable(name="year") String selectedYear,Model model) {	
		List<String> rollno=service.getAllRollno(selectedYear);
		return rollno;	
	}
	@RequestMapping("/selectedyear/{year}/{rollno}")
	@ResponseBody
	public List<String> GetNameAndMajorByRollNoAndYear(@PathVariable(name="year") String selectedYear,@PathVariable(name="rollno") String selectedRollno) {
		
		List<String> StudentName=service.StudentName(selectedYear, selectedRollno);
		return StudentName;
	}
	
	@RequestMapping(value="/MGT003",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("resultModel") ResultModel resultModel,BindingResult bindingResult,HttpSession session,Model model)
	{if(session.getAttribute("password_id")!=null){
		Long stu_id=resultModel.getStudentModel().getStu_id();		
		if(bindingResult.hasErrors()){		
			String studentInfoForUpdate =service.GetStudentInfo(stu_id);
			model.addAttribute("addingError",studentInfoForUpdate);
			model.addAttribute("studentInfoForUpdate",service.studentInfoForUpdate);
			
			if(stu_id==null)
			{
				model.addAttribute("studentNameError",service.GetStudentNameErrorMessage());
			}
			service.initialload(model);
			return "MGT003";
		}
		else{	
			service.AddMessage(stu_id,resultModel);
			
			return "redirect:/LGN002/MGT003";
			
		}
	}
	else {
		return "error";
	}
	}
	@RequestMapping("/editResultDetail/{id}")
	public ModelAndView Edit(@PathVariable(name="id") Long id,HttpSession session,Model model)
	{	if(session.getAttribute("password_id")!=null){
		
		ModelAndView mav=new ModelAndView("MGT003");
		ResultModel resultdetail=service.getResultDetail(id);
		service.EditDetail(model,resultdetail);
		mav.addObject("resultModel",resultdetail);
		model.addAttribute("resultModel",new ResultModel());
		service.initialload(model);
		return mav;
		
	}
	else {
		ModelAndView mav=new ModelAndView("/error") ;
		return mav;
	}
	}
	@RequestMapping("/deleteResult/{id}")
	public String deleteconfirm(@PathVariable(name="id") Long id,HttpSession session)
	{	if(session.getAttribute("password_id")!=null){
		
		service.DeleteDetail(id);
		return "redirect:/LGN002/MGT003";
	}
	
	else {
		return "error";
	}
	}
}
