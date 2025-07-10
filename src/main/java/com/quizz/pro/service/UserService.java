package com.quizz.pro.service;

import java.util.List;

import com.quizz.pro.entity.User;

public interface UserService {

	public List<User> verifyUser(String email, String password);
	public boolean  verifyEmail(String email);
	public boolean verifyOTP(int otp);
	public void forgotPWD(String email,String npassword);
	
}
