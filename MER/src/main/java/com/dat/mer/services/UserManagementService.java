package com.dat.mer.services;

import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dat.mer.dto.StudentManagementFormDTO;
import com.dat.mer.model.AdminModel;
import com.dat.mer.model.DivisionModel;
import com.dat.mer.model.MajorModel;
import com.dat.mer.model.PasswordModel;
import com.dat.mer.model.StudentModel;
import com.dat.mer.model.TownshipModel;
import com.dat.mer.repository.AdminRepository;
import com.dat.mer.repository.DivisionRepository;
import com.dat.mer.repository.MajorRepository;
import com.dat.mer.repository.PasswordRepository;
import com.dat.mer.repository.StudentRepository;
import com.dat.mer.repository.TownshipRepository;

@Service
@PropertySource("classpath:messages.properties")
public class UserManagementService {

	@Autowired 
	public StudentManagementFormDTO studentForm;
	@Autowired
	public StudentModel student;
	@Autowired
	public PasswordModel passwordModel;
	@Autowired
	public DivisionRepository divRepo;
	@Autowired
	public MajorRepository majorRepo;
	@Autowired
	public TownshipRepository townshipRepo;
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	public AdminRepository adminRepo;
	@Autowired
	public PasswordRepository pwdRepo;
	@Autowired
	public MajorModel majorModel;
	@Value( "${insert.success.message}" )
	public String insertSuccess;
	@Value( "${update.success.message}" )
	public String updateSuccess;
	@Value( "${delete.success.message}" )
	public String deleteSuccess;
	@Value( "${dataexist.message}" )
	public String dataExist;
	private String button="Add";
	private String message=null;
	private String link="/LGN002/MGT001/student_add";
	
	public List<DivisionModel> getDiv(){
		return divRepo.findAll();
	}
	
	public List<String> getTownshipsByDivision(String division) {
		List<String> townships = townshipRepo.getTownshipsByDivision(division);
		return townships;
	}
	public List<String> findByName(String findbyname){
		List<String> foundbyname=studentRepo.findByName(findbyname);
		return foundbyname;
	}
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
	
	public List<StudentModel> listAll(){
		return  studentRepo.findAll(); 
	}	
	public List<MajorModel> getAllMajor(){
		return majorRepo.findAll();
	}
	public String getTwnCode(String town) {
		return townshipRepo.getTwnCode(town);
	}
	//delete by Id
	public void deleteById(long id,Model model) {
		studentRepo.deleteById(id);
		setMessage(deleteSuccess);
	}
	//update student service
	public void updateStudent(StudentManagementFormDTO studentForm,Model model) {
		student=studentRepo.findById(studentForm.getStu_id()).get();
		student=formDataSet(studentForm,student);
		student.setStu_id(studentForm.getStu_id());
		if(studentForm.isReset_password())
		{	
			passwordModel=encryptPasswordModel(student.getPasswordmodel());
			student.setPasswordmodel(passwordModel);
		}
		studentRepo.save(student);
		setMessage(updateSuccess);
	}
	//add student service
	public void addStudent(StudentManagementFormDTO studentForm,Model model) {
		student=formDataSet(studentForm,student);
		
		String rollNumber=student.getStu_rollno();
		String year = student.getYear();
		if(studentRepo.countByRollAndYear(rollNumber,year) != 0)
		{
			setMessage(dataExist);
			
		}
		else 
		{
			if(studentForm.isReset_password())
			{	
				passwordModel=encryptPasswordModel(passwordModel);
				student.setPasswordmodel(passwordModel);
			}
			studentRepo.save(student);
			setMessage(insertSuccess);
		}	
	}
	//set student update form
	public StudentManagementFormDTO getStudentUpdateForm(long id) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		student=studentRepo.findById(id).get();	
		String roll_number=student.getStu_rollno();
		String[] parts=roll_number.split("-");
		Integer number=Integer.parseInt(parts[1]);
		String s = formatter.format(student.getStu_dob());
		studentForm.setMajor_id(student.getMajorModel().getMajor_id());
		studentForm.setDivision(student.getTownshipModel().getDivision().getDiv_name());
		studentForm.setTownship(student.getTownshipModel().getTwn_name());
		studentForm.setRollNumber(number);
		studentForm.setStu_name(student.getStu_name());
		studentForm.setYear(student.getYear());
		studentForm.setStu_school(student.getStu_school());
		studentForm.setStu_dob(s);
		studentForm.setStu_nrc(student.getStu_nrc());
		studentForm.setReset_password(true);
		studentForm.setStu_id(id);
		return studentForm;
	}
	//set data from student form to the student model
	public StudentModel formDataSet(StudentManagementFormDTO studentForm,StudentModel student) {
		String town_name=studentForm.getTownship();
		TownshipModel townModel=townshipRepo.findByNameLike(town_name);
		majorModel=majorRepo.findById(studentForm.getMajor_id()).get();
		student.setTownshipModel(townModel);
		student.setMajorModel(majorModel);
		student.setStu_rollno(townModel.getTwn_code()+"-"+studentForm.getRollNumber());
		student.setStu_name(studentForm.getStu_name());
		student.setStu_school(studentForm.getStu_school());
		student.setStu_dob(studentForm.toDate());
		String nrc=studentForm.getStu_nrc();
		if(nrc != null) {
		student.setStu_nrc(nrc);
		}
		else {
			student.setStu_nrc("-");
		}
		student.setYear(studentForm.getYear());
		return student;
	}
	
	//encrypt and set update timestamp to password model
	public PasswordModel encryptPasswordModel(PasswordModel password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(student.getStu_rollno());
		Timestamp time=Timestamp.valueOf(LocalDateTime.now());
		password.setPassword(hashedPassword);
		password.setUpdate_timestamp(time);
		if(password.getCreate_timestamp() == null) 
		{
			password.setCreate_timestamp(time);
		}
		password.setIsLoggedIn(false);
		return password;
	}
	//set student form
	public Model initiate(StudentManagementFormDTO studentForm,Model model) {
		
		List<StudentModel> studentList=listAll();
		List<DivisionModel> divisionList=getDiv();
		List<MajorModel> majorList = getAllMajor();
		studentForm.setStu_nrc("-");
		studentForm.setReset_password(true);
		model.addAttribute("link",getLink());
		model.addAttribute("message",getMessage());
		model.addAttribute("studentForm",studentForm);
		model.addAttribute("majorList",majorList);
		model.addAttribute("divisionList", divisionList);
		model.addAttribute("studentList", studentList);
		model.addAttribute("button",getButton());
		setButton("Add");
		setLink("/LGN002/MGT001/student_add");
		setMessage(null);
		return model;
	}
	//set student update form
	public Model updateInitiate(StudentManagementFormDTO studentForm,Model model) {
		setButton("Update");
		setLink("/LGN002/MGT001/student_update");
		return initiate(studentForm,model);
	}
	public List<String> getDivName(){
		return divRepo.getAllDivName();
	}
	
	public PasswordModel findByID(Long adminId){
		PasswordModel getAll=pwdRepo.findByID(adminId);
		return getAll;
	}
	
	/*public void setLoggedIn(Boolean isLoggedIn,Long passwordId){
		pwdRepo.setLoggedIn(isLoggedIn, passwordId);
	}*/
	
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
	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
