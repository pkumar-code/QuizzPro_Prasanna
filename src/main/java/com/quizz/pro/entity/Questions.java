package com.quizz.pro.entity;

import java.util.*;
import javax.persistence.*;
import io.swagger.annotations.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="myquestions")
@ApiModel("Questions  contains question_Id ,course_Id,topic_Id,correct_Answer") 
public class Questions{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=" question_Id ")
	@ApiModelProperty("holds  question_Id ")
	private int  question_Id ;
	
	@Column(name="question")
	@ApiModelProperty("holds question ")
	private String question;
	
	@Column(name="correct_Answer")
	@ApiModelProperty("holds correct_Answer ")
	private String correct_Answer;
	
	@ManyToOne
	@JoinColumn(name="topic_Id",referencedColumnName="topic_Id")
	private CourseTopics courseTopics;
	
	@ManyToOne
	@JoinColumn(name="course_Id",referencedColumnName="course_Id")
	private Courses courses;
	
	@OneToMany(mappedBy="questions",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<QuestionOptions> questionOptions;

	public Questions(int question_Id, String question, String correct_Answer) {
		super();
		this.question_Id = question_Id;
		this.question = question;
		this.correct_Answer = correct_Answer;
	}
	
	
}
