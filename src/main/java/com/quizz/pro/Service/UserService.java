package com.quizz.pro.Service;

import java.util.List;

import com.quizz.pro.Entity.User;

public interface UserService {

	public List<User> verifyUser(String email, String password);
	public boolean verifyOTP(int otp);
	
}
