package com.dat.mer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="major")
public class MajorModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="major_id")
	private Long major_id;
	@Column(name="major_name")
	private String major_name;
	@OneToMany(mappedBy="majorModel")
	public List<StudentModel> studentModel;
	public List<StudentModel> getStudentModel() {
		return studentModel;
	}
	public void setStudentModel(List<StudentModel> studentModel) {
		this.studentModel = studentModel;
	}
	public Long getMajor_id() {
		return major_id;
	}
	public void setMajor_id(Long major_id) {
		this.major_id = major_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
}
