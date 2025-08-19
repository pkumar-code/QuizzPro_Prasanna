package com.quizz.pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.pro.entity.CourseTopics;

@Repository
public interface CourseTopicsDAO extends JpaRepository<CourseTopics,Integer>{

	@Query(value="select * from mycourse_topics where course_Id=?",nativeQuery=true)
	List<CourseTopics> getCourseTopicsByCourse_Id( int courseId);
	
}
