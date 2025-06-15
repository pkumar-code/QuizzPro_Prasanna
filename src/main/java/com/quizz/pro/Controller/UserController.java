package com.quizz.pro.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizz.pro.Entity.User;
import com.quizz.pro.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String IndexPage() {
		System.out.println("---------------Login Page----------------------");
		
		return "login";
	}
	
	@GetMapping("/myuser")
	public String verifyUser(@RequestParam("email")String email,@RequestParam("pass")String pass
			          ,Model model,HttpServletRequest req) {
		
		String em=req.getParameter("email");
		String ps=req.getParameter("pass");
		String page="";
	
	   List< User> users=	userService.verifyUser(email, pass);  
	   User user=null;
	    System.out.println("---------------Verify User----------------------");
	    if(!users.isEmpty()) {
	    	user =users.get(0);
	    	//page="QuizzHome";
	    	page="verifyOtp";
	        model.addAttribute("EMAIL", em);
		    model.addAttribute("PS",ps);	       
	    }else {
	    	page="login";
	    }	       
		return page;
	}
	
	@GetMapping("/verifyotp")
	public String verifyOtP(@RequestParam("otp") String otp ) {
		
		String page="";
		boolean b=userService.verifyOTP(Integer.parseInt(otp));
		if(b==true) {
			page="QuizzHome";
		}else {
			page="verifyOtp";
		}
		return page;
	}
	
	
}
