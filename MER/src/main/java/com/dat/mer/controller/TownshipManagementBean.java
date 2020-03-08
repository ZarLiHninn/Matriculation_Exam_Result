package com.dat.mer.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dat.mer.model.TownshipModel;
import com.dat.mer.services.TownshipManagementService;

@Controller
@PropertySource("classpath:messages.properties")
@RequestMapping("/LGN002")
public class TownshipManagementBean {
	
	int isUpdate=0;	
	@Autowired
	private TownshipManagementService service;
	@RequestMapping("/MGT002")
    public String load(Model model,HttpSession session) {
		if(session.getAttribute("password_id")!=null){
			service.dataLoad(model);
		model.addAttribute("objects",new TownshipModel());
		return "MGT002";
		}
		else {
			return "error";
		}
		
}
	
	@RequestMapping(value="/MGT002",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objects") TownshipModel townshipModel,BindingResult bindingResult,HttpSession session,Model model)   
	{	
		String div_name="";
		boolean hasError=false;
		if(session.getAttribute("password_id")!=null){
			service.message="";
			service.dataLoad(model);
			try{
				div_name=townshipModel.getDivision().getDiv_name();
			}catch(Exception e) {
				System.out.println(e);
				model.addAttribute("messages", service.messages);
				hasError=true;
			}
			if(bindingResult.hasErrors()|hasError) {
			return "MGT002";
		}
			
		model.addAttribute("objects",new TownshipModel());
		service.message="";
			if(isUpdate==1) {
				for(int i=0;i<service.listAll.size();i++) {
			    	   if(service.listAll.get(i).getDivision().getDiv_name().equals(div_name) &
							service.listAll.get(i).getTwn_code().equals(townshipModel.getTwn_code()) & 
							service.listAll.get(i).getTwn_name().equals(townshipModel.getTwn_name())) {
			    		   service.message=service.dataexitmessage;
							service.button="Add";
                            service.dataLoad(model);
            				isUpdate=0;
                            return "/MGT002";
					}
			       }
				service.message=service.updatemessage;
				service.save(townshipModel);
				service.button="Add";
				service.dataLoad(model);
				isUpdate=0;
				return "/MGT002";
			}
			else if(isUpdate==0)
			{
				service.message="";
		       for(int i=0;i<service.listAll.size();i++) {
		    	   if(service.listAll.get(i).getDivision().getDiv_name().equals(div_name) &
						service.listAll.get(i).getTwn_code().equals(townshipModel.getTwn_code()) & 
						service.listAll.get(i).getTwn_name().equals(townshipModel.getTwn_name())) {
		    		   service.message=service.dataexitmessage;
					service.dataLoad(model);
					return "/MGT002";
				}
		       }
					service.save(townshipModel);
					service.message=service.insertmessage;
				}
		
		service.dataLoad(model);
		return "/MGT002";
		}
		
		else {
			return "error";
		}
		
	}
	@RequestMapping("/edit/{twn_id}")
	public ModelAndView edit(@PathVariable(name="twn_id") int id,HttpSession session,Model model)
	{

		if(session.getAttribute("password_id")!=null){
			service.message="";
			service.button="Update";
			isUpdate=1;
			service.dataLoad(model);
			ModelAndView mav=new ModelAndView("/MGT002") ;
			TownshipModel township=service.get(id);
			model.addAttribute("objects",township);
			model.addAttribute("button", service.button);
				
		return mav;
		}
		else {
			ModelAndView mav=new ModelAndView("/error") ;
			return mav;
		}
	}
	 @RequestMapping("/delete/{twn_id}") 
	 public String delete(@PathVariable(name="twn_id") int id,HttpSession session,Model model) {

		 service.message=service.delete(id);
	     return "redirect:/LGN002/MGT002";
	
	 
	
	}
	@RequestMapping("/reset")
	public String reset(Model model) {
		service.dataLoad(model);
		return "MGT002";
	}
}





















