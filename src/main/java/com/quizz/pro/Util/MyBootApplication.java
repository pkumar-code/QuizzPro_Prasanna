package com.quizz.pro.Util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2 
public class MyBootApplication  {

	static Logger log=LoggerFactory.getLogger(MyBootApplication.class);
	
public static void main(String[] args) {
	
	log.info("----MyBootApplication -----begin---------");
		SpringApplication.run(MyBootApplication.class, args);
	log.info("----MyBootApplication -----End---------");

	}

}
