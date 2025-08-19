package com.quizz.pro.dto;


import java.util.List;
import com.quizz.pro.entity.QuestionOptions;
import lombok.Data;

@Data
public class QuestionDTO  {
	
	private int qid;
	
	private String question;
	
	private List<QuestionOptions> options;

}
