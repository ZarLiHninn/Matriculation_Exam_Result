package com.dat.mer.controller;

import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dat.mer.model.Login;
import com.dat.mer.model.PasswordModel;
import com.dat.mer.model.ResultModel;
import com.dat.mer.model.passwordChange;
import com.dat.mer.services.AdminManagementService;
import com.dat.mer.services.ResultManagementService;
import com.dat.mer.services.UserManagementService;

@Controller
public class UserLoginBean {
	@Autowired 
	public AdminManagementService studentservice;
	@Autowired
	private ResultManagementService service;

   @RequestMapping("/LGN001/{list.res_id}")
   public String goToResultDetail(@PathVariable(name="list.res_id") Long res_id,@ModelAttribute("userLogin") Login userLogin,HttpSession session,Model model) {
	   
	   ResultModel result=service.getResultDetail(res_id);
       model.addAttribute("detailList",result);
       String err=(String) session.getAttribute("pwd");
       
	   if(err=="error1"){
      
       model.addAttribute("error1","error");
       session.removeAttribute("pwd");
       return "LGN001";
	   }
	   
	   else if(err=="error2"){
		   model.addAttribute("error2", "error");
		   session.removeAttribute("pwd");
		   return "LGN001";
	   }
	   
	   else if(err=="error3"){
		   model.addAttribute("error3", "error");
		   session.removeAttribute("pwd");
		   return "LGN001";
	   }
	   else {
		   return "LGN001";
	   }
   }
   
   @RequestMapping("/Detail/{list.res_id}")
   public String showResultDetail(HttpSession session,Model model){
	   Long res_id=(Long) session.getAttribute("resultid");
	   	ResultModel result=service.getResultDetail(res_id);

   		model.addAttribute("detail",result);
   		System.out.println("Hello ERI002 3");
   		/*session.removeAttribute("passwordID");
   		session.removeAttribute("resultid");
   		session.removeAttribute("stu_rollNo");
   		session.removeAttribute("stu_Id");*/
   		return "ERI002";
	   
   }
   

   @RequestMapping("/LGN/{list.res_id}")
    public String ShowResultDetail(@ModelAttribute("detailList") Login detailList,@PathVariable(name="list.res_id") Long res_id,@RequestParam(name="stu_rollNo")String stu_rollNo,@RequestParam(name="password")String password,HttpSession session,Model model) {
	   
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		
		System.out.println("Res Id"+res_id);
		
		Long studentId=studentservice.findByResId(res_id);
		PasswordModel pwdModel=studentservice.findByStuID(studentId);
		Long pwdID=pwdModel.getPassword_id();
		session.setAttribute("passwordID",pwdID);
		session.setAttribute("resultid", res_id);
		session.setAttribute("password",password);
		
		String time=String.valueOf(pwdModel.getUpdate_timestamp());
		LocalDateTime localDate1 = LocalDateTime.parse(time, formatter);
        LocalDateTime localDate2 = LocalDateTime.now();
        long months = ChronoUnit.MONTHS.between(localDate1,localDate2);
        System.out.println("months"+months);
		
		if(months<6 && password.equals(stu_rollNo)==false && passwordEncoder.matches(password,pwdModel.getPassword())){
	    	ResultModel result=service.getResultDetail(res_id);
	    	model.addAttribute("detail",result);
	    	System.out.println("Hello ERI002");
	    	return "redirect:/Detail/{list.res_id}";
				}
		else if(password.isEmpty()){
			session.setAttribute("pwd","error1");
			return "redirect:/LGN001/{list.res_id}";
			}
			
		else if(password.length()<5 || password.length()>20 || password.matches("[1-9]{5,20}")) { 
			   session.setAttribute("pwd","error3");
			   ResultModel result=service.getResultDetail(res_id);
			   model.addAttribute("detailList",result);
			   return "redirect:/LGN001/{list.res_id}";
			   
			}
		
		else if(password.equals(stu_rollNo) || months>6){
			
			System.out.print(stu_rollNo);
			if(passwordEncoder.matches(password,pwdModel.getPassword())){
			ResultModel result=service.getResultDetail(res_id);
			//session.setAttribute("stu_rollNo", stu_rollNo);
			session.setAttribute("stu_Id",result.studentModel.getStu_id());
			session.setAttribute("user","user");
			return "redirect:/PWC001";
			}
			else{	   
				session.setAttribute("pwd","error2");
			   ResultModel result=service.getResultDetail(res_id);
			   model.addAttribute("detailList",result);
			   return "redirect:/LGN001/{list.res_id}";
			}
		}
		
		else { 
		   session.setAttribute("pwd","error2");
		   ResultModel result=service.getResultDetail(res_id);
		   model.addAttribute("detailList",result);
		   return "redirect:/LGN001/{list.res_id}";
		   
			}
	    
    }

}
