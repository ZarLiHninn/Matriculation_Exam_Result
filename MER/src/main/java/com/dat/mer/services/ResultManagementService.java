package com.dat.mer.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.dat.mer.model.ResultModel;
import com.dat.mer.model.StudentModel;
import com.dat.mer.repository.ResultRepository;
import com.dat.mer.repository.StudentRepository;


@Service
public class ResultManagementService {
	@Autowired
	private ResultRepository resultRepo;
	@Autowired
	private StudentRepository studentRepo;
	String ButtonText="";
	String message=null;
	int IsUpdate=0;
	public String studentInfoForUpdate=null;
	
	@Value("${update.success.message}")
	private String updatemessage;
	@Value("${insert.success.message}")
	private String insertmessage;
	@Value("${dataexist.message}")
	private String dataexitmessage;
	@Value("${delete.success.message}")
	private String deletemessage;
	@Value("${action.fail.message}")
	private String failmessage;
	@Value("${YearAndName.NotCorrectly.Fill}")
	private String yearandnamenotcorrectlyfill;
	@Value("${StudentName.Error}")
	public String StudentNameError;
	
	public List<ResultModel> listAll(){
		return  resultRepo.findAll(); 
	}
	public boolean save(ResultModel res){
		boolean flag=true;
		try{resultRepo.save(res);}catch(Exception e){flag=true;}
		return flag;
		
	}
	
	public List<StudentModel> getAllStudent(){
		return (List<StudentModel>) studentRepo.findAll();
	}
	public List<StudentModel> listAlll(){
		return (List<StudentModel>) studentRepo.findAll();
	}

	public List<String> getAllYear(){
		return studentRepo.getAllYear();
	}
	public List<String> getAllRollno(String selectedYear){
		List<String> rollno=studentRepo.getAllRollno(selectedYear);
		return rollno;
	}
	public List<String> StudentName(String selectedYear,String selectedRollno){
		List<String> studentName=studentRepo.getAllStudentName(selectedYear, selectedRollno);
		return studentName;
	}
	public Long IsduplicateStuId(Long IsduplicateStuId){
		Long isduplicateStuId=resultRepo.IsduplicateStuId(IsduplicateStuId);
		return isduplicateStuId;
	}
	
	public ResultModel getResultDetail(Long id){
		return resultRepo.findById(id).get();
		
	} 
	public String GetStudentInfo(Long stuId){
		return studentRepo.GetStudentInfo(stuId);
	}
	public boolean deleteResult(Long id){
		boolean flag=true;
		try{resultRepo.deleteById(id);}catch(Exception e){flag=false;}
		return flag;
	}	
	public List<ResultModel> findAllList(String year, String name, String rollno) {	
		return resultRepo.findByAllByList(year,name,rollno);	
	}
	
	
	public List<ResultModel> findSelectYear(String year) {
		return resultRepo.findBySelectYear(year);
	}

	public List<ResultModel> findYear() {
		return resultRepo.findByYear();
	}
	
	public void initialload(Model model){
		List<ResultModel> listAll= listAll();
		model.addAttribute("resultlistall",listAll);
		List<String> year=getAllYear();
		List<String> indiyearlist=new ArrayList<String>();	
		for (int i=0; i<year.size(); i++){
			String eachyear=year.get(i);
			if(!indiyearlist.contains(eachyear)){
				indiyearlist.add(eachyear);
			}
		}
		
		model.addAttribute("yearlist", indiyearlist);
		model.addAttribute("buttonText", ButtonText);
		model.addAttribute("message", message);
	}
	public void SetNotificationMessage(String message)
	{
		this.message=message;
	}
	public void SetButtonText(String buttonText)
	{
		this.ButtonText=buttonText;
	}
	public void SetStudentInfoForUpdate(String studentInfoForUpdate)
	{
		this.studentInfoForUpdate=studentInfoForUpdate;
	}
	public void SetDataExitMessage()
	{
		SetButtonText("Add");
		message=dataexitmessage;
	}
	public void SetUpdateMessage(boolean flag){
		if(flag==true)this.message=updatemessage;
		else this.message=failmessage;
	}
	public void SetInsertMessage(boolean flag){
	if(flag==true)message=insertmessage;
	else message=failmessage;	
	}
	public void SetDataNotCorrectlyFill(){
		message=yearandnamenotcorrectlyfill;
	}
	public String GetStudentNameErrorMessage(){
		return StudentNameError;
	}
	public String SetStudentNameErrorMessage(String message){
		return StudentNameError=message;
	}
	public void AddMessage(Long stu_id,ResultModel resultModel){
		if(IsduplicateStuId(stu_id)!=null && IsUpdate==0 ){
			SetDataExitMessage();
		}
		else if(IsduplicateStuId(stu_id)!=null && IsUpdate==1){
			boolean flag=save(resultModel);
			SetUpdateMessage(flag);
		}
		else if(IsduplicateStuId(stu_id)==null && resultModel.getStudentModel().getStu_id()!=null && IsUpdate==0){
			boolean flag=save(resultModel);
			SetInsertMessage(flag);
		}
		else if(IsduplicateStuId(stu_id)==null && resultModel.getStudentModel().getStu_id()==null && IsUpdate==0){
			SetDataNotCorrectlyFill();
		}
		IsUpdate=0;
	}
	public void EditDetail(Model model,ResultModel resultdetail){
		studentInfoForUpdate =GetStudentInfo(resultdetail.getStudentModel().getStu_id());
		model.addAttribute("studentInfoForUpdate",studentInfoForUpdate);
		message="";
		IsUpdate=1;
		ButtonText= "Update";
	}
	public void DeleteDetail(Long id){
		message="";
		if(deleteResult(id)==true)message=deletemessage;
		else message=failmessage;
	}
}
