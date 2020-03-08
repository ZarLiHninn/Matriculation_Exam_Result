package com.dat.mer.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.dat.mer.model.ResultModel;
import com.dat.mer.model.StudentModel;

import com.dat.mer.services.ERI001Service;

@Controller
public class ExamResultFormBean {
	@Autowired
	private ERI001Service service;

	@RequestMapping("/")
	public String load(@ModelAttribute("student") StudentModel student, Model model, HttpSession session) {
		
		session.removeAttribute("admin");
		service.alldata(student, model, session);
		return "ERI001";
	}

	@PostMapping("/theWholeSearch")
	public String se(@RequestParam(name = "year") String year, @RequestParam(name = "stu_name") String name,
			@RequestParam(name = "stu_rollno") String rollno, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult bindingResult, Model model, HttpSession session) {
		service.allList(model, session);
		if (bindingResult.hasErrors()) {

			service.allList(model, session);

			System.out.print(bindingResult);
			return "ERI001";
		}

		@SuppressWarnings("unchecked")
		List<String> yearlist = (List<String>) session.getAttribute("AllYear");

		if (yearlist.contains(year) && name.equals("") && rollno.equals("")) {
			service.allList(model, session);
			List<ResultModel> rModel = service.findSelectYear(year);
			System.out.print(rModel);
			model.addAttribute("articles", rModel);
			return "ERI001";
		} else {
			service.allList(model, session);
			List<ResultModel> rModel = service.findAllList(year, name, rollno);
			System.out.print(rModel);
			model.addAttribute("articles", rModel);
			return "ERI001";

		}

	}

	@RequestMapping("/adminLogin.html")
	public String adminLogin() {
		return "LGN002";
	}

	@RequestMapping("/userLogin")
	public String userLogin() {
		return "LGN001";
	}
}
