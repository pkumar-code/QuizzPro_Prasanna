package com.quizz.pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;

@Repository
public interface QuestionOptionsDAO  extends JpaRepository<QuestionOptions,Integer>{
	
	@Query(value="select * from myquestion_options where  question_Id=?1",nativeQuery=true)
	 List<QuestionOptions> getQuestionOptionsByQuestion_Id(int question_Id);
}
