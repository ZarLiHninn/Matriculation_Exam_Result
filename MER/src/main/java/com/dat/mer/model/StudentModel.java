package com.dat.mer.model;


import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.dat.mer.model.ResultModel;
import com.dat.mer.model.MajorModel;
@Component
@Entity
@Table(name="student")
public class StudentModel{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="stu_id",nullable=false)
	private Long stu_id;
	
	@Size(min=0,max=16,message="Roll No must be less than 16")
	@Column(name="stu_rollno")
	private String stu_rollno;

	@Column(name="year")
	private String year;
	
	@Size(min=0,max=50,message="Student Name must be less than 50")
	@Column(name="stu_name")
	private String stu_name;

	@Column(name="stu_dob")
	private Date stu_dob;
	@Column(name="stu_nrc")
	private String stu_nrc;
	@Column(name="stu_school")
	private String stu_school;
	@OneToOne( mappedBy="studentModel" ,cascade=CascadeType.REMOVE, orphanRemoval=true,fetch = FetchType.LAZY)
	public ResultModel resultModel;
	@ManyToOne
	@JoinColumn(name="major_id")
	private MajorModel majorModel;
	@ManyToOne
	@JoinColumn(name="twn_id")
	private TownshipModel townshipModel;
	@OneToOne(cascade=CascadeType.ALL , orphanRemoval=true,fetch = FetchType.LAZY)
	@JoinColumn(name="password_id")
	public PasswordModel passwordmodel;
	
	public Long getStu_id() {
		return stu_id;
	}
	public void setStu_id(Long stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_rollno() {
		return stu_rollno;
	}
	public void setStu_rollno(String stu_rollno) {
		this.stu_rollno = stu_rollno;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}	
	
	public Date getStu_dob() {
		return stu_dob;
	}
	public void setStu_dob(Date date) {
		this.stu_dob = date;
	}
	public String getStu_nrc() {
		return stu_nrc;
	}
	public void setStu_nrc(String stu_nrc) {
		this.stu_nrc = stu_nrc;
	}
	public String getStu_school() {
		return stu_school;
	}
	public void setStu_school(String stu_school) {
		this.stu_school = stu_school;
	}	
	public MajorModel getMajorModel() {
		return majorModel;
	}
	public void setMajorModel(MajorModel majorModel) {
		this.majorModel = majorModel;
	}
	public TownshipModel getTownshipModel() {
		return townshipModel;
	}
	public void setTownshipModel(TownshipModel townshipModel) {
		this.townshipModel = townshipModel;
	}
	public PasswordModel getPasswordmodel() {
		return passwordmodel;
	}
	public void setPasswordmodel(PasswordModel passwordmodel) {
		this.passwordmodel = passwordmodel;
	}
	public ResultModel getResultModel() {
		return resultModel;
	}
	public void setResultModel(ResultModel resultModel) {
		this.resultModel = resultModel;
	}
	
}
