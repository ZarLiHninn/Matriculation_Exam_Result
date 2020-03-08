package com.dat.mer.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dat.mer.model.ResultModel;
import com.dat.mer.model.StudentModel;

import com.dat.mer.repository.ResultRepository;
import com.dat.mer.repository.StudentRepository;

@Service
public class ERI001Service {
	@Autowired
	private ResultRepository resultRepo;
	@Autowired
	private StudentRepository studentRepo;

	public List<ResultModel> listAll() {
		return resultRepo.findAll();
	}

	public List<StudentModel> getAllStudent() {
		return (List<StudentModel>) studentRepo.findAll();
	}

	public List<StudentModel> listAlll() {
		return (List<StudentModel>) studentRepo.findAll();
	}

	public List<String> getAllYear() {
		return studentRepo.getAllYear();
	}

	public ResultModel getResultDetail(Long id) {
		return resultRepo.findById(id).get();

	}

	public List<ResultModel> findAllList(String year, String name, String rollno) {
		return resultRepo.findByAllByList(year, name, rollno);

	}

	public List<ResultModel> findSelectYear(String year) {
		return resultRepo.findBySelectYear(year);
	}

	public List<ResultModel> findYear() {
		return resultRepo.findByYear();
	}

	public Model allList(Model model, HttpSession session) {
		List<StudentModel> listAll = studentRepo.findAll();
		String[] namelist = new String[listAll.size()];
		String[] idlist = new String[listAll.size()];
		List<String> yearlist = new ArrayList<String>();
		for (int i = 0; i < listAll.size(); i++) {
			StudentModel row = listAll.get(i);
			if (!Arrays.asList(namelist).contains(row.getStu_name())) {
				namelist[i] = row.getStu_name();
			}
			if (!Arrays.asList(idlist).contains(row.getStu_rollno())) {
				idlist[i] = row.getStu_rollno();
			}

			if (!yearlist.contains(row.getYear())) {
				yearlist.add(row.getYear());
			}
		}
		Collections.sort(yearlist);
		Collections.reverse(yearlist);
		model.addAttribute("listname", namelist);
		model.addAttribute("listid", idlist);
		model.addAttribute("listyear", yearlist);
		session.setAttribute("AllYear", yearlist);

		return model;

	}

	public List<ResultModel> alldata(StudentModel student, Model model, HttpSession session) {
        allList(model, session);
		List<ResultModel> articles = resultRepo.findByYear();
		System.out.println(articles.size());
		model.addAttribute("articles", articles);
		return articles;
	}

}
