package com.dat.mer.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dat.mer.model.PasswordModel;
import com.dat.mer.model.passwordChange;
import com.dat.mer.services.AdminManagementService;
import com.dat.mer.services.UserManagementService;

@Controller
public class PasswordChange {
	
	@Autowired 
	public AdminManagementService studentservice;

	
	@GetMapping("/PWC001")
	public String change(Model model){
		passwordChange pChange=new passwordChange();
		model.addAttribute("reset",pChange);
		return "PWC001";
		
	}
	@PostMapping("/PWC001")
	public String change(@Valid @ModelAttribute("reset") passwordChange reset,BindingResult bindingResult,HttpSession session,Model model){
		
		
		 String admin=(String) session.getAttribute("admin");
		 String user=(String) session.getAttribute("user");

		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 
		 Long passwordId;
		 String oldPassword;
		 String newPassword;
		 String comfirmPassword;
		 String password;
		 System.out.println(admin);
		   
		if(admin!=null){
		passwordId=(Long) session.getAttribute("password_id");
		

		System.out.print(passwordId);
		PasswordModel passwordModel=studentservice.findByPassID(passwordId);
		
		password=passwordModel.getPassword();
		System.out.println(password);
		oldPassword=reset.getOldPasswordd();
		newPassword=reset.getNewPasswordd();
		comfirmPassword=reset.getComfrmPasswordd();
		
		System.out.println(password+" "+oldPassword+" "+newPassword+" "+comfirmPassword);
		
		System.out.println((newPassword.equals(comfirmPassword)));
		
		   }
		   
		else {
				passwordId=(Long) session.getAttribute("passwordID");

				PasswordModel passwordModel=studentservice.findByPassID(passwordId);

				password=passwordModel.getPassword();
				System.out.println(password);
				
				oldPassword=reset.getOldPasswordd();	
				System.out.println(oldPassword);
						
				newPassword=reset.getNewPasswordd();
				comfirmPassword=reset.getComfrmPasswordd();
				   
		   }
		
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
            return "PWC001";
        }
		
		else if(admin!=null && (bindingResult.hasErrors())!=true &&(passwordEncoder.matches(oldPassword, password)==true ) && (newPassword.equals(comfirmPassword))){
			String encodeedPass=passwordEncoder.encode(newPassword);
			LocalDateTime time = LocalDateTime.now();
			System.out.println(session.getAttribute("adminId"));
			Long adminId=Long.valueOf((String) session.getAttribute("adminId"));
			String name=studentservice.getAdmin(adminId).getAdmin_name();
			Timestamp updateTimestamp =Timestamp.valueOf(time);
			
			//System.out.println(updateTimestamp+"update time");
			
			session.setAttribute("adminName", name);
			studentservice.passwordChange(encodeedPass,passwordId );
			studentservice.setLoggedIn(true,passwordId);
			studentservice.updateTimestamp(updateTimestamp, passwordId);
			return "redirect:/LGN002/HPG001";
			}
		else if(user!=null && (bindingResult.hasErrors())!=true &&(passwordEncoder.matches(oldPassword, password)==true )&&(newPassword.equals(password)!=true ) && (newPassword.equals(comfirmPassword))==true){
			String encodeedPass=passwordEncoder.encode(newPassword);
			
			Long resultId=(Long) session.getAttribute("resultid");
		   	LocalDateTime time = LocalDateTime.now();

	   		System.out.println(time);
			Timestamp updateTimestamp =Timestamp.valueOf(time);
			studentservice.updateTimestamp(updateTimestamp, passwordId);
			studentservice.passwordChange(encodeedPass,passwordId);
			System.out.println("Hello ERI002 2");
			System.out.println(passwordId);
			return "redirect:/Detail/"+resultId;
			}
		else if(newPassword.length()<5 || newPassword.length()>20){
				model.addAttribute("newPwd","size");
				return "PWC001";
			}
		else if(comfirmPassword.length()<5 || comfirmPassword.length()>20){
			model.addAttribute("cfPwd","size");
			return "PWC001";
			}
			
		else if(newPassword.equals(oldPassword)){
			model.addAttribute("same","same");
			return "PWC001";
			
			}
		else if(passwordEncoder.matches(oldPassword, password)!=true && (newPassword.equals(comfirmPassword))!=true){
			model.addAttribute("wrongPwd", "wrongPwd");
			model.addAttribute("newPwd", "newPwd");
			
			return "PWC001";
			}
	 
		else if (passwordEncoder.matches(oldPassword, password)!=true){	
			model.addAttribute("wrongPwd", "wrongPwd");
			return "PWC001";
			}
		else{
			model.addAttribute("newPwd", "newPwd");
			return "PWC001";
			}
		
		
	}

}
