package com.dat.mer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	private long admin_id;
	@Column(name="admin_name")
	private String admin_name;
	@OneToOne(orphanRemoval=true)
	@JoinColumn(name="password_id")
	public PasswordModel passwordModel;
	
	public PasswordModel getPasswordModel() {
		return passwordModel;
	}
	public void setPasswordModel(PasswordModel passwordModel) {
		this.passwordModel = passwordModel;
	}
	public long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	
}
