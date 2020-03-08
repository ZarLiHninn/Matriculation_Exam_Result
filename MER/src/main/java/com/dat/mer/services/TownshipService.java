package com.dat.mer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dat.mer.model.TownshipModel;
import com.dat.mer.repository.TownshipRepository;

@Service
public class TownshipService {

	@Autowired
	private TownshipRepository townshipRepository;
	public List<TownshipModel> listAll(){
		return townshipRepository.findAll();
	}
	
	public TownshipModel get(int id){
		return townshipRepository.findById(id).get();
	}

	public void save(TownshipModel townshipModel) {
		townshipRepository.save(townshipModel);
	}

	public boolean delete(Integer id) {
		try{
			townshipRepository.deleteById(id);
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
		
	}
}
