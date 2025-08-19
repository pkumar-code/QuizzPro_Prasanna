package com.quizz.pro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.quizz.pro.dto.QuestionDTO;
import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;
import com.quizz.pro.entity.Questions;
import com.quizz.pro.entity.TestResults;
import com.quizz.pro.service.UserService;



@Controller
@SessionAttributes("{USER,COUNAME,TOPICNAME}")
public class StudentController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/topic")
	public String getTopicsByCourseName(@RequestParam int couId,
			@RequestParam String couName,
			HttpSession session) {
		
	   List<CourseTopics> mylist=userService.getTopicsByCourseId(couId);
	   
	   Map<Integer, String> mymap = new LinkedHashMap<>();
		for (int i = 0; i < mylist.size(); i++) {
			Integer topicId = mylist.get(i).getTopic_Id();
			String topicName = mylist.get(i).getTopic_Name();
			mymap.put(topicId, topicName);
		}
		session.setAttribute("COUID",couId);
		session.setAttribute("COUNAME",couName);
	    session.setAttribute("TOPICS",mymap);
		
		return "selectTopic";
	}
	
	@GetMapping("/startTest")
	public String startTest(@RequestParam int topicId,
			@RequestParam String topicName,
			HttpSession session) {
		
		session.setAttribute("TOPICNAME",topicName);
		session.setAttribute("TOPICID", topicId);
		
		return "startTest";
	}
	
	@GetMapping("/questionsPage")
	public String getQuestionsByTopicId(@RequestParam String topicId,
			HttpServletRequest req) {

		 
		List<Questions> ques=userService.getAllQuestionsByTopicId(Integer.parseInt(topicId));
		
		List<QuestionOptions> list=null;
		
		List<QuestionDTO> listdto=new ArrayList<>();
		
            for (Questions que:ques) {
            	QuestionDTO qdto=new QuestionDTO();
            	 int qid=que.getQuestion_Id();
            	 qdto.setQid(que.getQuestion_Id());
            	 qdto.setQuestion(que.getQuestion());
			      list=  userService.getQuestionOptionsByQuestionId(qid);   
			      qdto.setOptions(list);
			      listdto.add(qdto);
            }
            
        req.getSession().setAttribute("currentIndex",0);	
        req.getSession().setAttribute("score",0);	
		req.getSession().setAttribute("Questionsdto",listdto);
		return "testPage";
	}
	
	@PostMapping("/next")
	public String next(@RequestParam int qid, 
			@RequestParam String question, 
			@RequestParam String option, 
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        int index = (int) request.getSession().getAttribute("currentIndex");
        int size = (int) request.getSession().getAttribute("SIZE");
         int score = (int) request.getSession().getAttribute("score");
         
        String page="";
        String status="Wrong";
       
         Questions ques = userService.viewQuestionById(qid);
        if(ques.getCorrect_Answer().equals(option)) {
        	score++;
        	status="Correct";
        }
       
        	TestResults results=new TestResults();
            results.setQid(qid);
            results.setQuestion(question);
            results.setCorrectAnswer(ques.getCorrect_Answer());
            results.setYourAnswer(option);
            results.setStatus(status);
            userService.addTestResults( results);
                 index++;
        request.getSession().setAttribute("currentIndex", index);
        request.getSession().setAttribute("score", score);
        if(index  != size ) {
    	    	page="testPage";
        }else {
        	page="redirect:/submit";
        }
        
        return page;
    }
	
	@GetMapping("/submit")
	public String startTest(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
		List<TestResults> list=userService.getAllTestResults();
		 int score = (int) request.getSession().getAttribute("score");
		 int size = (int) request.getSession().getAttribute("SIZE");
		 
				 
		model.addAttribute("LIST",list );
		session.setAttribute("score", score);
		session.setAttribute("SIZE", size);
		return "resultsPage";
	}
	
}
