package com.quizz.pro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name="mycourses")
@ApiModel("Courses  contains course_Id,course_Name") 
public class Courses {
	
	@Id
	@Column(name="course_Id")
	@ApiModelProperty("holds course_Id ")
	private int course_Id;
	
	@Column(name="course_Name")
	@ApiModelProperty("holds course_Name")
	private String course_Name;
	
	@OneToMany(mappedBy="courses",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CourseTopics> courseTopics;
	
	@OneToMany(mappedBy="courses",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Questions> questions;
		
		
}
