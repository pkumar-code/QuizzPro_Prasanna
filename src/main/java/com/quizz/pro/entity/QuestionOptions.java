package com.quizz.pro.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name=" myquestion_options")
@ApiModel("QuestionOptions  contains question_Id ,option_id,option_data") 
public class QuestionOptions{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="option_id")
	@ApiModelProperty("holds option_id ")
	private int option_id;
	
	@Column(name="option_data")
	@ApiModelProperty("holds option_data ")
	private String option_data;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="question_Id",referencedColumnName="question_Id")
	private Questions questions;	
	
}
