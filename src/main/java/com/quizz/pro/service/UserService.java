package com.quizz.pro.service;

import java.util.List;

import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;
import com.quizz.pro.entity.Questions;
import com.quizz.pro.entity.User;

public interface UserService {

	public List<User> verifyUser(String email, String password);

	public boolean verifyEmail(String email);

	public boolean verifyOTP(int otp);

	public void forgotPWD(String email, String npassword);

	//////////////////////////////////////////////////

	public List<Courses> getCourses();

	public List<CourseTopics> getTopics();

	public void addQuestion(Questions questions);

	public int countQuestions();

	public List<Questions> getAllQuestions();

	public List<Questions> viewAllQuestions(int start, int total);
	public List<Questions> getAllQuestions(int couId, int topicId);

	public Questions viewQuestionById(int questionId);

	public void updateQuestion(Questions questions);

	public void deleteQuestion(int questionId);

	public List<QuestionOptions> getQuestionOptionsByQuestionId(int questionId);

	
	
}
