package com.dat.mer.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

import com.dat.mer.model.Login;
import com.dat.mer.services.AdminManagementService;
import com.dat.mer.services.ResultManagementService;




@Controller
@RequestMapping("/LGN002")
public class AdminLoginBean {
	public ResultManagementService userservice;
	@Autowired 
	public AdminManagementService studentservice;
	
	@GetMapping()
	public String load(Model model,HttpSession session) {
		model.addAttribute("employee", new Login());
		if(session.getAttribute("adminName")!=null)
			return "redirect:/LGN002/HPG001";
		else return "LGN002";
	}
	
	

	@PostMapping()
	    public String login(@Valid @ModelAttribute("employee") Login employee, BindingResult bindingResult,HttpSession session,Model model) {
		
		 if (bindingResult.hasErrors()) {
			 System.out.println(bindingResult);
		            return "LGN002";
		        }
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	        
	        String userInputPass=employee.getAdminPassword();
	        Long userInputId=Long.valueOf(employee.getAdminID());
	        System.out.println(userInputId);
	        
	        Long id=(long) 1;
	        Boolean adminId;
	        String pass;
	        String time;
	        Boolean isLogIn;
	        try{
	        	id=studentservice.getAdmin(userInputId).getAdmin_id();
	        	adminId=true;
	        	pass=studentservice.findByID(id).getPassword();
	        	time=String.valueOf(studentservice.findByID(id).getUpdate_timestamp());
	        	isLogIn=studentservice.findByID(id).getIsLoggedIn();
		        
		        
	        }catch(Exception e){
	        	adminId=false;
	        	pass="";
	        	time=String.valueOf(studentservice.findByID(id).getUpdate_timestamp());
	        	isLogIn=false;
	        }
	       
	        LocalDateTime localDate1 = LocalDateTime.parse(time, formatter);
	        LocalDateTime localDate2 = LocalDateTime.now();
	        long months = ChronoUnit.MONTHS.between(localDate1,localDate2);
	       
	        if(employee.getAdminID().length()<3 || employee.getAdminID().length()>7 || passwordEncoder.matches(userInputPass, pass)!=true || userInputPass.length()<5 || userInputPass.length()>20 ){
	        	if(employee.getAdminID().length()<3 || employee.getAdminID().length()>7) {
		        	model.addAttribute("format","error");
		        	return "LGN002";
	    	   }
	        	else if(userInputPass.length()<5 || userInputPass.length()>20 ) {
		        	model.addAttribute("sizeError","error");
		        	return "LGN002";
	    	   }
	    	   else { model.addAttribute("error","error");
	        	 return "LGN002";
	    	   }
	        }
	        
	        else if(isLogIn==false && months<6 && passwordEncoder.matches(userInputPass, pass)==true ){
	        	String name=studentservice.getAdmin(userInputId).getAdmin_name();
	        	Long password_id=studentservice.findByID(userInputId).getPassword_id();
		        
	        	session.setAttribute("Id",userInputId);
	        	session.setAttribute("password", pass);
	        	session.setAttribute("adminName", name);
	        	session.setAttribute("password_id",password_id);
	        	studentservice.setLoggedIn(true,password_id);
	        	return "redirect:/LGN002/HPG001";
	        }
	       
	        
	        else if(isLogIn==false && months>6 && passwordEncoder.matches(userInputPass, pass)==true ){
	        	String name=studentservice.getAdmin(userInputId).getAdmin_name();
	        	Long password_id=studentservice.findByID(userInputId).getPassword_id();
		        

	        	session.setAttribute("admin","admin");
	        	session.setAttribute("adminId", employee.getAdminID());
	        	session.setAttribute("password", pass);
	        	session.setAttribute("password_id",password_id);
	        	session.setAttribute("adminName", name);
	        	
	 			return "redirect:/PWC001";
	        
	        }
	        /*
	        else if(session.getAttribute("adminName")==null) {
	        	if(passwordEncoder.matches(userInputPass, pass)==true){
	        		String name=studentservice.getAdmin(userInputId).getAdmin_name();
		        	Long password_id=studentservice.findByID(userInputId).getPassword_id();
			        
		        	session.setAttribute("Id",userInputId);
		        	session.setAttribute("password", pass);
		        	session.setAttribute("adminName", name);
		        	session.setAttribute("password_id",password_id);
		        	studentservice.setLoggedIn(true,password_id);
		        	return "redirect:/LGN002/HPG001";	
	        	
	        	}
	        	
	        	else {
		        	System.out.println("Logged In");
		        	return "LGN002";
	        	}
	        	
	        }*/
	        else {
	        	model.addAttribute("duplicate","duplicate");
	        	System.out.println("Logged In");
	        	return "error";
        	}
	        	
	        	
	    }
	
	
	}

