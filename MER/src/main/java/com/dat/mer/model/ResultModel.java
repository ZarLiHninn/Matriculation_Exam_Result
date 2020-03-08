package com.dat.mer.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.PropertySource;

@Entity
@Table(name="result")

public class ResultModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="res_id")
	private Long id;
	@NotNull
	@Range(min=0,max=100)
	@Column(name="Myan")
	private Integer Myan;
	@NotNull
	@Range(min=0,max=100)
	@Column(name="Engl")
	private Integer Engl;
	@NotNull
	@Range(min=0,max=100)
	@Column(name="Math")
	private Integer Math;
	@NotNull
	@Range(min=0,max=100)
	@Column(name="Chem")
	private Integer Chem;
	@NotNull
	@Range(min=0,max=100)
	@Column(name="Phys")
	private Integer Phys;
	@NotNull
	@Range(min=0,max=100)
	@Column(name="Bio_Eco")
	private Integer Bio_Eco;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stu_id",nullable=false)
	@NotNull
	public StudentModel studentModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMyan() {
		return Myan;
	}

	public void setMyan(Integer myan) {
		Myan = myan;
	}

	public Integer getEngl() {
		return Engl;
	}

	public void setEngl(Integer engl) {
		Engl = engl;
	}

	public Integer getMath() {
		return Math;
	}

	public void setMath(Integer math) {
		Math = math;
	}

	public Integer getChem() {
		return Chem;
	}

	public void setChem(Integer chem) {
		Chem = chem;
	}

	public Integer getPhys() {
		return Phys;
	}

	public void setPhys(Integer phys) {
		Phys = phys;
	}

	public Integer getBio_Eco() {
		return Bio_Eco;
	}

	public void setBio_Eco(Integer bio_Eco) {
		Bio_Eco = bio_Eco;
	}

	public StudentModel getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}

	
	
	

}
