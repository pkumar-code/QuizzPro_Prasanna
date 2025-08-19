package com.quizz.pro.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.User;
import com.quizz.pro.service.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
@SessionAttributes("USER")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	private Map<Integer, String> getAllCourses() {

		List<Courses> mylist = userService.getCourses();
		Map<Integer, String> mymap = new LinkedHashMap<>();
		for (int i = 0; i < mylist.size(); i++) {
			Integer couId = mylist.get(i).getCourse_Id();
			String couName = mylist.get(i).getCourse_Name();
			mymap.put(couId, couName);
		}
		return mymap;
	}

	
	

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
		log.info("----info---------UserController --verifyUser------------------ ");
		log.debug("-----debug-----UserController --verifyUser-----------------");
		log.error("-----error-------UserController---verifyUser----------------");
		
		String page = "";
		String em = req.getParameter("email");
		String ps = req.getParameter("pass");

		List<User> users = userService.verifyUser(email, pass);
		User user = null;
		if (!users.isEmpty()) {
			user = users.get(0);
			page = "verifyOtp";
			
			model.addAttribute("EMAIL", em);
			model.addAttribute("PS", ps);		
			model.addAttribute("RESEND", "TRUE");
		} else {
			page = "login";
		}	
		HttpSession session=req.getSession();
		session.setAttribute("USER",user);
		return page;
	}

	@GetMapping("/verifyotp")
	@ApiOperation(value = " verifiesOtp", response = String.class, notes = "Gives  verfies otp")
	public String verifyOtP(@RequestParam("otp") String otp,Model model) {

		log.info("----info---------UserController --verifyOtP------------------ ");
		log.debug("-----debug-----UserController --verifyOtP-----------------");
		log.error("-----error-------UserController---verifyOtP----------------");
		
		String page = "";
		User user = userService.verifyOTP(Integer.parseInt(otp));
		String role=user.getUser_Role();
		if (role.equals("Teacher")) {
			page = "teacherHome";
		}else if(role.equals("Student")) {
		   page="studentHome";	
		   Map<Integer, String> mycourses = getAllCourses();
		   model.addAttribute("COURSE",mycourses);
		}else  {
			page = "verifyOtp";
		}
		return page;
	}

	@GetMapping("/verifyEmail")
	@ApiOperation(value = " getVerifiedEmail", response = String.class, notes = "Gives user verify with  Email")
	public String verifyEmail(@RequestParam("email") String email, Model model, HttpServletRequest req) {

		log.info("----info---------UserController --verifyEmail------------------ ");
		log.debug("-----debug-----UserController --verifyEmail-----------------");
		log.error("-----error-------UserController---verifyEmail-----------------");
		
		String page = "";
		String em = req.getParameter("email");
		boolean b = userService.verifyEmail(email);
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
		log.info("----info---------UserController --verifyOtpPWD------------------ ");
		log.debug("-----debug-----UserController --verifyOtpPWD-----------------");
		log.error("-----error-------UserController---verifyOtpPWD-----------------");
		
		String page = "";
		String em = req.getParameter("email");
		User user= userService.verifyOTP(Integer.parseInt(otp));
		if (user!=null) {
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
	
	@GetMapping("/logout")
	public String getLogout(Model model, HttpServletRequest req) {
		
		log.info("----info---------UserController ---getLogout------------------ ");
		log.debug("-----debug-----UserController ---getLogout----------------");
		log.error("-----error-------UserController----getLogout----------------");
		
		String page = "login";
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();
		}

		return page;

	}
	

}
