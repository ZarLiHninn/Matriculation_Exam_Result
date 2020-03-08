package com.dat.mer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dat.mer.services.AdminManagementService;
import com.dat.mer.services.UserManagementService;

@Controller
@RequestMapping("/LGN002")
public class AdminHomeBean {
	@Autowired 
	public AdminManagementService studentservice;
	
		@GetMapping("/HPG001")
		public String load(HttpSession session) {
			if(session.getAttribute("password_id")!=null)
			return "HPG001";
			else return "redirect:/ERI001";
		}
		
		@GetMapping("/logout")
		public String logoutPage(HttpSession session) {
			Long password_id=(Long) session.getAttribute("password_id");
			studentservice.setLoggedIn(false,password_id);
			session.removeAttribute("password_id");
			session.removeAttribute("adminName");
			session.invalidate();
	        return "redirect:/";
	    }
}
