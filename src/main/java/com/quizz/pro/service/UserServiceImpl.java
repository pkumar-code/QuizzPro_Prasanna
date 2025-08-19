package com.quizz.pro.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.pro.dao.CourseTopicsDAO;
import com.quizz.pro.dao.CoursesDAO;
import com.quizz.pro.dao.QuestionOptionsDAO;
import com.quizz.pro.dao.QuestionsDAO;
import com.quizz.pro.dao.TestResultsDAO;
import com.quizz.pro.dao.UserDAO;
import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;
import com.quizz.pro.entity.Questions;
import com.quizz.pro.entity.TestResults;
import com.quizz.pro.entity.User;
import com.quizz.pro.template.EmailTemplate;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	

	@Autowired
	UserDAO userDAO;

	@Autowired
	CoursesDAO coursesDAO;
	
	@Autowired
	CourseTopicsDAO courseTopicsDAO;
	
	@Autowired
	QuestionsDAO questionsDAO;
	
	@Autowired
	QuestionOptionsDAO questionOptionsDAO;
	
	@Autowired
	TestResultsDAO  testResultsDAO;
		
	@Autowired
	EmailTemplate Etemp;
	
	
	public int generateOTP() {
		double genOtp = (1000000 * Math.random());
		int otp = (int) Math.floor(genOtp);
		System.out.println("------generateOtp--------" + otp);
		return otp;
	}

	@Override
	public List<User> verifyUser(String email, String password) {
		
		log.info("------UserServiceImpl---verifyUser------------");
		
		int otp = generateOTP();
		List<User> user = userDAO.findUserByEmailAndPassword(email, password);
	   User ur =  user.get(0);
	   
	   int uid =ur.getUser_Id(); 
		String fn=ur.getFull_Name();
		 long ph=ur.getPhone();
		 String pass=ur.getPassword();
		String role=ur.getUser_Role();
		String st=ur.getStatus();
		User uer =new User(uid,fn,email,ph, pass,role,otp,st);
    
       userDAO.saveAndFlush(uer);
    		   
       
		String from = "pkumar.c028@gmail.com";
		String to = "05m1bdu3hw@mrotzis.com";
		String subject = "Quizz Pro  OTP";
		String body = "<font color=black size=5>  OTP For  Login - QuizzPro :  </font>" + "<h1>" + otp + "</h1>";
		Etemp.sendMail(from, to, subject, body);

		return user;
	}

	@Override
	public User verifyOTP(int otp) {
		log.info("------UserServiceImpl---verifyOTP------------");
		return userDAO.findUserByOtp(otp);
	}

	@Override
	public void forgotPWD(String email, String npassword) {
		log.info("------UserServiceImpl---forgotPWD------------");
		User user  =	userDAO.findUserByEmail(email);
		int uid =user.getUser_Id(); 
		String fn=user.getFull_Name();
		 long ph=user.getPhone();
		String role=user.getUser_Role();
		int otp=user.getOtp();
		String st=user.getStatus();
		User ur =new User(uid,fn,email,ph, npassword,role,otp,st);
		userDAO.saveAndFlush(ur);

	}

	@Override
	public boolean verifyEmail(String email) {
		log.info("------UserServiceImpl---verifyEmail------------");
		boolean b = false; 
		User user  =	userDAO.findUserByEmail(email);
		if(user!=null) {
			b=true;
		}
		
		int otp = generateOTP();
		
		int uid =user.getUser_Id(); 
		String fn=user.getFull_Name();
		 long ph=user.getPhone();
		 String pass=user.getPassword();
		String role=user.getUser_Role();
		String st=user.getStatus();
		User ur =new User(uid,fn,email,ph, pass,role,otp,st);
		userDAO.saveAndFlush(ur);
		
		String from = "pkumar.c028@gmail.com";
		String to = "ram@mailinator.com";
		String subject = "Quizz Pro  OTP";
		String body = "<font color=black size=5>  OTP For  Login - QuizzPro :  </font>" + "<h1>" + otp + "</h1>";
        Etemp.sendMail(from, to, subject, body);
		return b;
	}

	

	@Override
	public List<Courses> getCourses() {
	
		return coursesDAO.findAll();
	}

	@Override
	public List<CourseTopics> getTopics() {
		
		return courseTopicsDAO.findAll();
		
	}

	@Override
	public void addQuestion(Questions questions) {
	
		questionsDAO.save(questions);
	}

	@Override
	public List<Questions> getAllQuestions1(int start, int total) {
		System.out.println("1. "+start);
		System.out.println("2. "+total);
		
		Pageable page = PageRequest.of(start, total);
		return  questionsDAO.findAll(page).toList();
	}

	@Override
	public int countQuestions() {
		
		return (int) questionsDAO.count();
	}

	@Override
	public List<Questions> viewAllQuestions(int start, int total) {
		System.out.println("1. "+start);
		System.out.println("2. "+total);
		
		Pageable page=PageRequest.of(start, total);	
		
		List<Questions> list=questionsDAO.getAllQuestions(page);
		
			return list;
	}

	@Override
	public Questions viewQuestionById(int questionId) {
		
		Optional<Questions> ques=questionsDAO.findById(questionId);
		return ques.get();
	}

	@Override
	public void updateQuestion(Questions questions) {
		questionsDAO.saveAndFlush(questions);
		
	}

	@Override
	public void deleteQuestion(int questionId) {
		Optional<Questions> ques=questionsDAO.findById(questionId);
		if(ques.get()!=null) {
			questionsDAO.deleteById(questionId);
		}
	}

	@Override
	public List<QuestionOptions> getQuestionOptionsByQuestionId(int questionId) {
		
		
		return questionOptionsDAO.getQuestionOptionsByQuestion_Id(questionId);
	}

	@Override
	public List<Questions> getAllQuestions(int couId, int topicId) {
		
		return questionsDAO.getQuestionsByCourse_IdAndTopic_Id(couId, topicId);
	}

	@Override
	public List<CourseTopics> getTopicsByCourseId(int courseId) {
		
		return courseTopicsDAO.getCourseTopicsByCourse_Id(courseId);
	}

	@Override
	public List<Questions> getAllQuestionsByTopicId(int topicId) {
		
		return questionsDAO.getQuestionsByTopic_Id(topicId);
	}

	@Override
	public void addTestResults(TestResults result) {
		
				testResultsDAO.save(result);
	}

	@Override
	public List<TestResults> getAllTestResults() {
		
		return testResultsDAO.findAll();
	}
	
	
}
