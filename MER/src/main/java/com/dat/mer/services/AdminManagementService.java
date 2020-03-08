package com.dat.mer.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dat.mer.model.AdminModel;
import com.dat.mer.model.Login;
import com.dat.mer.model.PasswordModel;
import com.dat.mer.repository.AdminRepository;
import com.dat.mer.repository.PasswordRepository;
import com.dat.mer.repository.StudentRepository;

@Service
public class AdminManagementService {
	
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	public PasswordRepository pwdRepo;
	@Autowired
	public PasswordModel passwordModel;
	@Autowired
	private StudentRepository studentRepo;
	
	public String getIsAdmin(Long adminId){
		String getIsAdmin=studentRepo.getIsAdmin(adminId);
		return getIsAdmin;
	}
	public AdminModel getAdmin(Long adminId){
		AdminModel getAdmin=adminRepo.getAdmin(adminId);
		return getAdmin;
	}
	
	public String getUpdateTimestamp(Long adminId){
		String getTime=pwdRepo.getUpdateTimestamp(adminId);
		return getTime;
	}
	
	public PasswordModel findByID(Long adminId){
		PasswordModel getAll=pwdRepo.findByID(adminId);
		return getAll;
	}
	
	public void setLoggedIn(Boolean isLoggedIn,Long passwordId){
		pwdRepo.setLoggedIn(isLoggedIn, passwordId);
	}
	
	public void passwordChange(String password,Long passwordId){
		pwdRepo.passwordChange(password, passwordId);
	}
	
	public void updateTimestamp(Timestamp updateTimestamp,Long passwordId){
		pwdRepo.updateTimestamp(updateTimestamp, passwordId);
	}
	public PasswordModel findByPassID(Long passwordId) {
		PasswordModel getAll=pwdRepo.findByPassID(passwordId);
		return getAll;
	}
	public PasswordModel findByStuID(Long stu_Id) {
		PasswordModel getAll=pwdRepo.findByStuID(stu_Id);
		return getAll;
	}
	
	public Long findByResId(Long userId){
		Long stu_id=pwdRepo.findByResId(userId);
		return stu_id;
	}
	
	


}
