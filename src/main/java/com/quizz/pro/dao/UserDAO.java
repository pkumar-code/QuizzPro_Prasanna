package com.quizz.pro.dao;

import java.util.List;

import com.quizz.pro.entity.User;

public interface UserDAO {

	public List<User> verifyUser(String email, String password);

	public boolean verifyEmail(String email);

	public void updateUser(String email, int otp);

	public boolean verifyOTP(int otp);

	public void forgotPWD(String email, String npassword);

}
