package com.quizz.pro.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="myresults")
public class TestResults {
	
	@Id
	@Column(name="test_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testId;
	
	@Column(name="qid")
	private int qid;
	
	@Column(name="question")
	private String question;
	
	@Column(name="correctAnswer")
	private String correctAnswer;

	@Column(name="yourAnswer")
	private String yourAnswer;
	
	@Column(name="status")
	private String status;
	
	
	
	

}
