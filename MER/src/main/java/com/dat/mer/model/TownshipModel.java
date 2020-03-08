package com.dat.mer.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="township")
public class TownshipModel {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="twn_id")
	private int twn_id;
	@NotNull
	@Pattern(regexp ="^[a-zA-Z]*$")
	@Size(min=4,max=8)
	@Column(name="twn_code")
	public String twn_code;
	
	@NotNull
	@Pattern(regexp ="^[a-zA-Z/\\s/g]*$")
	@Size(min=1,max=30)
	@Column(name="twn_name")
	private String twn_name;
	@OneToMany(mappedBy="townshipModel",cascade = CascadeType.ALL)
	private List<StudentModel> studentModel;
	@ManyToOne()
	@JoinColumn(name="div_id")
	private DivisionModel division;
	
	
	/**
	 * @return the twn_id
	 */
	public int getTwn_id() {
		return twn_id;
	}
	/**
	 * @param twn_id the twn_id to set
	 */
	public void setTwn_id(int twn_id) {
		this.twn_id = twn_id;
	}
	public DivisionModel getDivision() {
		return division;
	}
	public void setDivision(DivisionModel division) {
		this.division = division;
	}
	public void setTwn_code(String twn_code) {
		this.twn_code = twn_code;
	}
	public String getTwn_name() {
		return twn_name;
	}
	public void setTwn_name(String twn_name) {
		this.twn_name = twn_name;
	}
	public List<StudentModel> getStudentModel() {
		return studentModel;
	}
	public void setStudentModel(List<StudentModel> studentModel) {
		this.studentModel = studentModel;
	}
	public String getTwn_code() {
		return twn_code;
	}	
}
