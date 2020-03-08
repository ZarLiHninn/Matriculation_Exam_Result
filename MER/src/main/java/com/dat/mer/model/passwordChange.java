package com.dat.mer.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class passwordChange {
	@NotEmpty
	private String oldPasswordd;
	
	@NotEmpty
	/*@Pattern(regexp="[a-z][A-Z][0-9])(?=.*?\\W)]")*/
	private String newPasswordd;
	
	@NotEmpty
	private String comfrmPasswordd;
	
	public String getOldPasswordd() {
		return oldPasswordd;
	}
	public void setOldPasswordd(String oldPasswordd) {
		this.oldPasswordd = oldPasswordd;
	}
	public String getNewPasswordd() {
		return newPasswordd;
	}
	public void setNewPasswordd(String newPasswordd) {
		this.newPasswordd = newPasswordd;
	}
	public String getComfrmPasswordd() {
		return comfrmPasswordd;
	}
	public void setComfrmPasswordd(String comfrmPasswordd) {
		this.comfrmPasswordd = comfrmPasswordd;
	}

}
