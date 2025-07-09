package com.quizz.pro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizz.pro.entity.User;
import com.quizz.pro.service.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String IndexPage() {
		log.info("----info---------UserController --index page------------------ ");
		log.debug("-----debug-----UserController --index page-----------------");
		log.error("-----error-------UserController---index page----------------");

		return "login";
	}

	@GetMapping("/myuser")
	@ApiOperation(value = " getVerifyUser", response = String.class, notes = "Get verified user with given email and password")
	public String verifyUser(@RequestParam("email") String email, @RequestParam("pass") String pass, Model model,
			HttpServletRequest req) {

		String page = "";

		String em = req.getParameter("email");
		String ps = req.getParameter("pass");

		List<User> users = userService.verifyUser(email, pass);
		User user = null;
		log.info("----info---------UserController --verifyUser------------------ ");
		log.debug("-----debug-----UserController --verifyUser-----------------");
		log.error("-----error-------UserController---verifyUser----------------");
		if (!users.isEmpty()) {
			user = users.get(0);
			page = "verifyOtp";
			model.addAttribute("EMAIL", em);
			model.addAttribute("PS", ps);
			model.addAttribute("RESEND", "TRUE");
		} else {
			page = "login";
		}
		return page;
	}

	@GetMapping("/verifyotp")
	@ApiOperation(value = " verifiesOtp", response = String.class, notes = "Gives  verfies otp")
	public String verifyOtP(@RequestParam("otp") String otp) {

		String page = "";
		boolean b = userService.verifyOTP(Integer.parseInt(otp));
		log.info("----info---------UserController --verifyOtP------------------ ");
		log.debug("-----debug-----UserController --verifyOtP-----------------");
		log.error("-----error-------UserController---verifyOtP----------------");
		if (b == true) {
			page = "QuizzHome";
		} else {
			page = "verifyOtp";
		}
		return page;
	}

	@GetMapping("/verifyEmail")
	@ApiOperation(value = " getVerifiedEmail", response = String.class, notes = "Gives user verify with  Email")
	public String verifyEmail(@RequestParam("email") String email, Model model, HttpServletRequest req) {

		String page = "";
		String em = req.getParameter("email");
		boolean b = userService.verifyEmail(email);
		log.info("----info---------UserController --verifyEmail------------------ ");
		log.debug("-----debug-----UserController --verifyEmail-----------------");
		log.error("-----error-------UserController---verifyEmail-----------------");
		if (b == true) {
			model.addAttribute("EM", em);
			page = "PwdOtp";
		} else {
			page = "login";
		}
		return page;
	}

	@GetMapping("/verifyotpPWD")
	@ApiOperation(value = " getOtpPWD", response = String.class, notes = "Gives user verify  otp with given email")
	public String verifyOtpPWD(@RequestParam("email") String email, @RequestParam("otp") String otp, Model model,
			HttpServletRequest req) {

		String page = "";

		String em = req.getParameter("email");
		boolean b = userService.verifyOTP(Integer.parseInt(otp));
		log.info("----info---------UserController --verifyOtpPWD------------------ ");
		log.debug("-----debug-----UserController --verifyOtpPWD-----------------");
		log.error("-----error-------UserController---verifyOtpPWD-----------------");
		if (b == true) {
			page = "forgotpw";
			model.addAttribute("EM", em);
		} else {
			page = "login";
		}
		return page;
	}

	@GetMapping("/forgotpw")
	@ApiOperation(value = "getForgotPWD", response = String.class, notes = "Gives ")
	public String forgotPWD(@RequestParam("email") String email, @RequestParam("npass") String npassword) {

		log.info("----info---------UserController ---forgotPWD------------------ ");
		log.debug("-----debug-----UserController ---forgotPWD----------------");
		log.error("-----error-------UserController----forgotPWD----------------");
		userService.forgotPWD(email, npassword);

		return "login";
	}

}
