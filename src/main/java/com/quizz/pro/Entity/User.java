package com.quizz.pro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myusers")
public class User {
	
	@Id
	@Column(name="user_Id")
	private int user_Id;
	
	@Column(name="full_Name")
	private String full_Name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="password")
	private String password;
	
	@Column(name="otp")
	private int otp;
	
	@Column(name="status")
	private String status;
	
	public User() {}
	
	public User(int user_Id, String full_Name, String email, long phone, String password, int otp, String status) {
		super();
		this.user_Id = user_Id;
		this.full_Name = full_Name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.otp = otp;
		this.status = status;
	}
	public User( String full_Name, String email, long phone, String password, int otp, String status) {
	
		this.full_Name = full_Name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.otp = otp;
		this.status = status;
	}
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getFull_Name() {
		return full_Name;
	}
	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return user_Id + "\t" + full_Name + "\t" + email + "\t" + phone
				+ "\t" + password + "\t" + otp + "\t" + status;
	}
	
}
