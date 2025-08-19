package com.quizz.pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;

@Repository
public interface CoursesDAO  extends JpaRepository<Courses,Integer>{
	
	

}
