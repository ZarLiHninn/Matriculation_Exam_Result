package com.dat.mer.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="division")
public class DivisionModel {
	@OneToMany(mappedBy="division",cascade = CascadeType.ALL)
	private List<TownshipModel> townshipModel;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="div_id")
	public int div_id;
	@Column(name="div_name")
	public String div_name;
	
	
	public String getDiv_name() {
		return div_name;
	}
	public void setDiv_name(String div_name) {
		this.div_name = div_name;
	}
	public Integer getDiv_id() {
		return div_id;
	}
	public void setDiv_id(Integer div_id) {
		this.div_id = div_id;
	}	
}
