package com.quizz.pro.dao;

import java.util.List;

import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;
import com.quizz.pro.entity.Questions;
import com.quizz.pro.entity.User;

public interface UserDAO {

	public List<User> verifyUser(String email, String password);

	public boolean verifyEmail(String email);

	public void updateUser(String email, int otp);

	public boolean verifyOTP(int otp);

	public void forgotPWD(String email, String npassword);

	/////////// Teachers Module///////////////////////////

	public List<Courses> getCourse();
	public List<CourseTopics> getTopics();
	
	public List<Questions> getAllQuestions();
	public List<Questions>viewAllQuestions(int start,int total);
	public List<Questions> getAllQuestions(int couId,int topicId);
	
	/////////////////////////////////////////
	
	public void addQuestion(Questions questions);
	public int countQuestions();

	public Questions viewQuestionById(int questionId);
	public int updateQuestion(Questions questions);
	public void deleteQuestion(int questionId);
	
	public List<QuestionOptions> getQuestionOptionsByQuestionId(int question_Id);
		
	public void updateOptionsByQuestionId(int question_Id,List<QuestionOptions> UpdatedquestionOptions);
		
}
