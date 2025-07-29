package com.quizz.pro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="mycourse_topics")
@ApiModel("CourseTopics  contains topic_Id,course_Id,topic_Name,no_Of_Questions") 
public class CourseTopics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=" topic_Id")
	@ApiModelProperty("holds  topic_Id")
	private int  topic_Id;
	
//	@Column(name="course_Id")
//	@ApiModelProperty("holds course_Id ")
//	private int course_Id;
	
	@Column(name="topic_Name")
	@ApiModelProperty("holds topic_Name ")
	private String topic_Name;
	
	@Column(name="no_Of_Questions")
	@ApiModelProperty("holds no_Of_Questions ")
	private long no_Of_Questions;
	
	
	@ManyToOne
	@JoinColumn(name="course_Id",referencedColumnName="course_Id")
	private Courses courses;
	
	
	@OneToMany(mappedBy="courseTopics",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Questions> questions;
		

	
}
