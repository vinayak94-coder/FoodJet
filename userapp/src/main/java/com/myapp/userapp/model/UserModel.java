package com.myapp.userapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {
	
	@Id
	String mail;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	String name;
	String password;
	String location;
	@Override
	public String toString() {
		return "UserModel [mail=" + mail + ", name=" + name + ", password=" + password + ", location=" + location
				+ ", mobile=" + mobile + "]";
	}
	String mobile;

}
