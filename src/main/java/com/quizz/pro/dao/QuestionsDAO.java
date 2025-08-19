package com.quizz.pro.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.pro.entity.Questions;

@Repository
public interface QuestionsDAO  extends JpaRepository<Questions,Integer>{
	
	 @Query(value="from Questions questions ")
	 List<Questions>getAllQuestions(Pageable pageable);
	
	
	@Query(value="select * from myquestions where course_Id=?1 and topic_Id=?2",nativeQuery=true)
	 List<Questions> getQuestionsByCourse_IdAndTopic_Id(int couId,int topicId);
	
	@Query(value="select * from myquestions where  topic_Id=?1",nativeQuery=true)
	List<Questions> getQuestionsByTopic_Id(int topicId);	
	
	
	
}
