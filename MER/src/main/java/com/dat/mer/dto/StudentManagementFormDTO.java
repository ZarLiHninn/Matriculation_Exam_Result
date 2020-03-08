package com.dat.mer.dto;

import java.sql.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dat.mer.repository.StudentRepository;
import com.dat.mer.validate.DivisionNotExist;
import com.dat.mer.validate.TownshipNotExist;
@Component
public class StudentManagementFormDTO {
@Autowired
StudentRepository studentRepo;
private long stu_id;
@NotEmpty
@DivisionNotExist
private String division;
@NotEmpty
@TownshipNotExist
private String township;
@NotNull
@Range(min=0)
private Integer rollNumber;
@NotNull
@Size(min=10,max=50)
private String stu_name;
@NotNull
@Size(min=4,max=4)
private String year;
@NotNull
@Size(min=10,max=35)
private String stu_school;
@NotNull
@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
private String stu_dob;
//@Pattern(regexp="^$ | ^\\-{1}$ | ^[0-9]{2}[/]{1}[a-z,A-Z]+[(]{1}[a-z,A-Z]+[)]{1}[0-9]{6}$")
private String stu_nrc;
private long major_id;
private boolean reset_password;
public long getStu_id() {
	return stu_id;
}
public void setStu_id(long stu_id) {
	this.stu_id = stu_id;
}
public String getStu_dob() {
	return stu_dob;
}
public void setStu_dob(String stu_dob) {
	this.stu_dob = stu_dob;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getTownship() {
	return township;
}
public void setTownship(String township) {
	this.township = township;
}
public Integer getRollNumber() {
	return rollNumber;
}
public void setRollNumber(Integer rollNumber) {
	this.rollNumber = rollNumber;
}
public String getStu_name() {
	return stu_name;
}
public void setStu_name(String stu_name) {
	this.stu_name = stu_name;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getStu_school() {
	return stu_school;
}
public void setStu_school(String stu_school) {
	this.stu_school = stu_school;
}
public String getStu_nrc() {
	return stu_nrc;
}
public void setStu_nrc(String stu_nrc) {
	this.stu_nrc = stu_nrc;
}

public boolean isReset_password() {
	return reset_password;
}
public void setReset_password(boolean reset_password) {
	this.reset_password = reset_password;
}
public long getMajor_id() {
	return major_id;
}
public void setMajor_id(long major_id) {
	this.major_id = major_id;
}
public Date toDate() {
	return Date.valueOf(stu_dob);
}

}
