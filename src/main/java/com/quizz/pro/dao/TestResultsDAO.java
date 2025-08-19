package com.quizz.pro.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.pro.entity.TestResults;

@Repository
public interface TestResultsDAO  extends JpaRepository<TestResults,Integer>{
	
	 
	
	
	
}
