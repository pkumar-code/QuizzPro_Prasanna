package com.quizz.pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;
import com.quizz.pro.entity.Questions;
import com.quizz.pro.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	List<User> findUserByEmailAndPassword(String email, String password);

	User findUserByEmail(String email);

	User findUserByOtp(int otp);



}
