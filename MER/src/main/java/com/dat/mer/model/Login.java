package com.dat.mer.model;

import javax.validation.constraints.NotEmpty;



public class Login {
		@NotEmpty
		private String adminID;
		
		@NotEmpty
		private String adminPassword;

		public String getAdminID() {
			return adminID;
		}

		public void setAdminID(String adminID) {
			this.adminID = adminID;
		}

		public String getAdminPassword() {
			return adminPassword;
		}

		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		
		
		
}