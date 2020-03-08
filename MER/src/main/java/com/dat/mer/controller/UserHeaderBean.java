package com.dat.mer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dat.mer.dto.StudentManagementFormDTO;
import com.dat.mer.model.DivisionModel;
import com.dat.mer.model.MajorModel;
import com.dat.mer.model.StudentModel;
import com.dat.mer.services.UserManagementService;
@Controller
public class UserHeaderBean {
	@Autowired
	public UserManagementService userService;
	@Autowired
	StudentManagementFormDTO studentForm;
	@RequestMapping("/LGN002/MGT001")
	public String load(Model model,StudentManagementFormDTO initStudentForm,HttpSession session) {
		if(session.getAttribute("password_id")!=null)
		{
		userService.initiate(initStudentForm,model);
		return "MGT001";
		}
		else
		{
			return "error";
		}
	}
	@GetMapping("/getTownship/{dev}")
	@ResponseBody
	public List<String> getTownshipsByDivision(@PathVariable(name="dev") String division) {
		
		List<String> townships=userService.getTownshipsByDivision(division);
		return townships;
	}
	@PostMapping("/LGN002/MGT001/student_add")
	public String add(@Valid @ModelAttribute("studentForm")StudentManagementFormDTO studentForm , BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			userService.initiate(studentForm,model);
			return "MGT001";
		}
		userService.addStudent(studentForm, model);
		return "redirect:/LGN002/MGT001";
		
	}
	@PostMapping("/LGN002/MGT001/student_update")
	public String update(@Valid @ModelAttribute("studentForm")StudentManagementFormDTO studentForm , BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			userService.updateInitiate(studentForm,model);
			return "MGT001";
		}
		userService.updateStudent(studentForm, model);
		return "redirect:/LGN002/MGT001";
	}
	
	@GetMapping("/LGN002/MGT001/student_update/{id}")
	public String update(@PathVariable(name="id")long id , Model model) {
		studentForm=userService.getStudentUpdateForm(id);
		userService.updateInitiate(studentForm,model);
		return "MGT001";
	}
	@GetMapping("/LGN002/MGT001/student_delete/{id}")
	public String delete(@PathVariable(name="id") long id, Model model) {
		userService.deleteById(id, model);
		return "redirect:/LGN002/MGT001";
		
	}
	
	/*@RequestMapping("/findbyadmin/{id}/{password}")
	@ResponseBody
	public List<String> getIsAdmin(@PathVariable(name="id") Long id,@PathVariable(name="password") String password) {
		
		List<String> foundname=userService.getIsAdmin(id, password);

		return foundname;
	}*/
}
