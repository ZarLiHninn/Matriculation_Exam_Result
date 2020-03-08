package com.dat.mer.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dat.mer.model.DivisionModel;
import com.dat.mer.model.TownshipModel;
import com.dat.mer.repository.DivisionRepository;
import com.dat.mer.repository.TownshipRepository;

@Service
public class TownshipManagementService {

	@Autowired
	private TownshipRepository townshipRepository;
	public List<TownshipModel> listAll(){
		return townshipRepository.findAll();
	}
	@Autowired
	public DivisionRepository divisionRepository;
	public List<TownshipModel> listAll;
	public List<DivisionModel> divisions;
	public String button="Add";
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	@Value("${update.success.message}") public String updatemessage;
	@Value("${insert.success.message}") public String insertmessage;
	@Value("${dataexit.message}") public String dataexitmessage;
	@Value("${delete.message}") public String deletemessage;
	@Value("${NotNull.objects.division}")public String messages;
	public String message="";
	
	public void dataLoad(Model model) {
		listAll= this.listAll();
		divisions=(List<DivisionModel>) divisionRepository.findAll();
		model.addAttribute("townships",listAll);
		model.addAttribute("divisions",divisions);
		model.addAttribute("button",button);
		model.addAttribute("message",message);
		message="";
	}
	
	public TownshipModel get(int id){
		return townshipRepository.findById(id).get();
	}

	public void save(TownshipModel townshipModel) {
		
		townshipRepository.save(townshipModel);
	}

	public String delete(Integer id) {
		try{
			townshipRepository.deleteById(id);
		}catch(Exception e) {
			System.out.println(e);
		}
		return deletemessage;
		
	}
}
