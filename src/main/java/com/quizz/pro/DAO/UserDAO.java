package com.quizz.pro.DAO;

import java.util.List;

import com.quizz.pro.Entity.User;

public interface UserDAO {
	
	public List<User> verifyUser(String email, String password);

	public void updateUser(String email,int otp);
	
	public boolean  verifyOTP(int otp);
	

}
