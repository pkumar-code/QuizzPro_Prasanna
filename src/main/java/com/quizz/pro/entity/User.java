package com.quizz.pro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="myusers")
@ApiModel("User  contains userId,fullName,email,phone,password,otp,status") 
public class  User {
	
	@Id
	@Column(name="user_Id")
	@ApiModelProperty("holds  user_Id ")
	private int user_Id;
	
	@Column(name="full_Name")
	@ApiModelProperty("holds full_Name")
	private String full_Name;
	
	@Column(name="email")
	@ApiModelProperty("holds email")
	private String email;
	
	@Column(name="phone")
	@ApiModelProperty("holds phone")
	private long phone;
	
	@Column(name="password")
	@ApiModelProperty("holds password")
	private String password;
	
	@Column(name="otp")
	@ApiModelProperty("holds otp")
	private int otp;
	
	@Column(name="status")
	@ApiModelProperty("holds status")
	private String status;
	
	public User() {}
	
	
	
	
}
