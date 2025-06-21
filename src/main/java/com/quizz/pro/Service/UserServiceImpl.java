package com.quizz.pro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.pro.DAO.UserDAO;
import com.quizz.pro.Entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	MailService mailService;

	@Override
	public List<User> verifyUser(String email, String password) {

		List<User> user = userDAO.verifyUser(email, password);

		int otp = generateOTP();

		userDAO.updateUser(email, otp);

		String from = "pkumar.c028@gmail.com";
		String to = "ram@mailinator.com";
		String subject = "Quizz Pro  OTP";
		String body = "<font color=black size=5>  OTP For  Login - QuizzPro :  </font>" + "<h1>" + otp + "</h1>";
		mailService.sendMail(from, to, subject, body);

		return user;
	}

	@Override
	public boolean verifyOTP(int otp) {

		boolean b = userDAO.verifyOTP(otp);

		return b;
	}

	@Override
	public void forgotPWD(String email, String npassword) {
		userDAO.forgotPWD(email, npassword);

	}

	@Override
	public boolean verifyEmail(String email) {

		boolean b = userDAO.verifyEmail(email);
		int otp = generateOTP();
		userDAO.updateUser(email, otp);

		String from = "pkumar.c028@gmail.com";
		String to = "ram@mailinator.com";
		String subject = "Quizz Pro  OTP";
		String body = "<font color=black size=5>  OTP For  Login - QuizzPro :  </font>" + "<h1>" + otp + "</h1>";
		mailService.sendMail(from, to, subject, body);

		return b;
	}

	public int generateOTP() {
		double genOtp = (1000000 * Math.random());
		int otp = (int) Math.floor(genOtp);
		System.out.println("------generateOtp--------" + otp);
		return otp;
	}

}
