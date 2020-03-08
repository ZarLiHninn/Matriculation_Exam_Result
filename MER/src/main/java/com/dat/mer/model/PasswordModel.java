package com.dat.mer.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="password")
public class PasswordModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="password_id")
	private long password_id;
	@Column(name="password")
	private String password;
	@Column(name="create_timestamp")
	private Timestamp create_timestamp;
	@Column(name="update_timestamp")
	private Timestamp update_timestamp;
	@Column(name="is_logged_in")
	private Boolean isLoggedIn;
	
	public long getPassword_id() {
		return password_id;
	}
	public void setPassword_id(long password_id) {
		this.password_id = password_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreate_timestamp() {
		return create_timestamp;
	}
	public void setCreate_timestamp(Timestamp create_timestamp) {
		this.create_timestamp = create_timestamp;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}

	@OneToOne(mappedBy="passwordModel")
	public AdminModel adminModel;
	public AdminModel getAdminModel() {
		return adminModel;
	}
	public void setAdminModel(AdminModel adminModel) {
		this.adminModel = adminModel;
	}
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
}
