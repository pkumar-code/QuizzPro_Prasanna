package com.quizz.pro.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.pro.dao.UserDAO;
import com.quizz.pro.entity.User;
import com.quizz.pro.template.EmailTemplate;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	EmailTemplate Etemp;

	@Override
	public List<User> verifyUser(String email, String password) {
		
		log.info("------UserServiceImpl---verifyUser------------");
		
		int otp = generateOTP();
		userDAO.updateUser(email, otp);
		
		List<User> user = userDAO.verifyUser(email, password);

		String from = "pkumar.c028@gmail.com";
		String to = "habhgpsle3@zudpck.com";
		String subject = "Quizz Pro  OTP";
		String body = "<font color=black size=5>  OTP For  Login - QuizzPro :  </font>" + "<h1>" + otp + "</h1>";
		Etemp.sendMail(from, to, subject, body);

		return user;
	}

	@Override
	public boolean verifyOTP(int otp) {
		log.info("------UserServiceImpl---verifyOTP------------");
		boolean b = userDAO.verifyOTP(otp);

		return b;
	}

	@Override
	public void forgotPWD(String email, String npassword) {
		log.info("------UserServiceImpl---forgotPWD------------");
		userDAO.forgotPWD(email, npassword);

	}

	@Override
	public boolean verifyEmail(String email) {
		log.info("------UserServiceImpl---verifyEmail------------");
		boolean b = userDAO.verifyEmail(email);
		int otp = generateOTP();
		userDAO.updateUser(email, otp);

		String from = "pkumar.c028@gmail.com";
		String to = "ram@mailinator.com";
		String subject = "Quizz Pro  OTP";
		String body = "<font color=black size=5>  OTP For  Login - QuizzPro :  </font>" + "<h1>" + otp + "</h1>";
        Etemp.sendMail(from, to, subject, body);
		return b;
	}

	public int generateOTP() {
		double genOtp = (1000000 * Math.random());
		int otp = (int) Math.floor(genOtp);
		System.out.println("------generateOtp--------" + otp);
		return otp;
	}

}
