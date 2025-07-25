package com.quizz.pro.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;
import com.quizz.pro.entity.Questions;
import com.quizz.pro.service.UserService;

@Controller
@SessionAttributes("TotalQuestions")
public class TeacherController {

	private static final Logger log = LoggerFactory.getLogger(TeacherController.class);

	@Autowired
	UserService userService;

	int start = 0;
	int end = 5;
	int totalDisplay = 5;
	int totalQuestions;

	private void showFirstPage(Model model) {

		start = 0;
		end = 5;
		totalDisplay = 5;
		totalQuestions = (int) userService.countQuestions();

		model.addAttribute("FROM", start + 1);
		model.addAttribute("TO", end);
		model.addAttribute("TotalQuestions", totalQuestions);

		model.addAttribute("ShowPrevious", "FALSE");
		model.addAttribute("ShowNext", "TRUE");

	}

	@GetMapping("/nextLeads")
	public String showNextQuestions(Model model) {

		start = start + totalDisplay;
		if (start <= 0) {
			start = 0;
			model.addAttribute("ShowPrevious", "FALSE");
		} else {
			model.addAttribute("ShowPrevious", "TRUE");
		}

		model.addAttribute("FROM", start + 1);

		end = end + totalDisplay;
		if (end >= totalQuestions) {
			model.addAttribute("TO", totalQuestions);
			model.addAttribute("ShowNext", "FALSE");
		} else {
			model.addAttribute("TO", end);
			model.addAttribute("ShowNext", "TRUE");
		}
		List<Questions> myquestions = userService.viewAllQuestions(start, totalDisplay);
		model.addAttribute("ALLQUESTIONS", myquestions);
		return "viewQuestions";
	}

	@GetMapping("/previousLeads")
	public String showPreviousQuestions(Model model) {

		start = start - totalDisplay;
		if (start <= 0) {
			start = 0;
			model.addAttribute("ShowPrevious", "FALSE");
		} else {
			model.addAttribute("ShowPrevious", "TRUE");
		}
		model.addAttribute("FROM", start + 1);
		end = end - totalDisplay;
		if (end >= totalQuestions) {
			model.addAttribute("TO", totalQuestions);
			model.addAttribute("ShowNext", "FALSE");
		} else {
			model.addAttribute("TO", end);
			model.addAttribute("ShowNext", "TRUE");
		}

		List<Questions> myquestions = userService.viewAllQuestions(start, totalDisplay);
		model.addAttribute("ALLQUESTIONS", myquestions);
		return "viewQuestions";
	}

	private Map<Integer, String> getAllCourses() {

		List<Courses> mylist = userService.getCourses();
		Map<Integer, String> mymap = new LinkedHashMap<>();
		for (int i = 0; i < mylist.size(); i++) {
			Integer couId = mylist.get(i).getCourse_Id();
			String couName = mylist.get(i).getCourse_Name();
			mymap.put(couId, couName);
		}
		return mymap;
	}

	private Map<Integer, String> getAllCourseTopics() {

		List<CourseTopics> mylist = userService.getTopics();

		Map<Integer, String> mymap = new LinkedHashMap<>();
		for (int i = 0; i < mylist.size(); i++) {
			Integer topicId = mylist.get(i).getTopic_Id();
			String topicName = mylist.get(i).getTopic_Name();
			mymap.put(topicId, topicName);
		}

		return mymap;

	}

	@GetMapping("/addquestionpage")
	public String getQuestionPage(Model model, HttpServletRequest req) {

		Map<Integer, String> mycourses = getAllCourses();
		Map<Integer, String> mytopics = getAllCourseTopics();

		HttpSession session = req.getSession();
		session.setAttribute("COURSES", mycourses);
		session.setAttribute("TOPICS", mytopics);

		return "addQuestion";
	}

	@PostMapping("/addquestion")
	public String addQuestion(@RequestParam int course, @RequestParam int topic, @RequestParam String question,
			@RequestParam String optA, @RequestParam String optB, @RequestParam String optC, @RequestParam String optD,
			@RequestParam String correct, Model model, HttpServletRequest req) {

		log.info("----info---------TeacherController --addQuestion()------------------ ");
		log.debug("-----debug-----TeacherController --addQuestion()-----------------");
		log.error("-----error-------TeacherController---addQuestion()----------------");

		Courses cou = new Courses();
		cou.setCourse_Id(course);

		CourseTopics top = new CourseTopics();
		top.setTopic_Id(topic);

		Questions questions = new Questions();

		List<QuestionOptions> opts = new ArrayList<>();

		QuestionOptions qoptA = new QuestionOptions();
		qoptA.setOption_data(optA);
		qoptA.setQuestions(questions);
		opts.add(qoptA);

		QuestionOptions qoptB = new QuestionOptions();
		qoptB.setOption_data(optB);
		qoptB.setQuestions(questions);
		opts.add(qoptB);

		QuestionOptions qoptC = new QuestionOptions();
		qoptC.setOption_data(optC);
		qoptC.setQuestions(questions);
		opts.add(qoptC);

		QuestionOptions qoptD = new QuestionOptions();
		qoptD.setOption_data(optD);
		qoptD.setQuestions(questions);
		opts.add(qoptD);

		questions.setQuestion(question);
		questions.setCorrect_Answer(correct);
		questions.setCourses(cou);
		questions.setCourseTopics(top);
		questions.setQuestionOptions(opts);

		userService.addQuestion(questions);

		return "teacherHome";
	}

	@GetMapping("/viewquestionspage")
	public String viewQuestions(Model model, HttpServletRequest req) {

		log.info("----info---------TeacherController --viewQuestions()------------------ ");
		log.debug("-----debug-----TeacherController --viewQuestions()-----------------");
		log.error("-----error-------TeacherController---viewQuestions()----------------");

		List<Questions> allquestions = userService.viewAllQuestions(start, totalDisplay);
		Map<Integer, String> mycourses = getAllCourses();
		Map<Integer, String> mytopics = getAllCourseTopics();

		HttpSession session = req.getSession();
		session.setAttribute("COURSES", mycourses);
		session.setAttribute("TOPICS", mytopics);

		model.addAttribute("ALLQUESTIONS", allquestions);
		showFirstPage(model);
		return "viewQuestions";
	}

	@GetMapping("/viewQuestion")
	public String questionInfo(@RequestParam("questionId") int questionId, Model model) {
		Questions ques = userService.viewQuestionById(questionId);
		List<QuestionOptions> list = userService.getQuestionOptionsByQuestionId(questionId);

		List<String> mylist = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			String optionData = list.get(i).getOption_data();
			mylist.add(optionData);
		}

		String couName = ques.getCourses().getCourse_Name();
		String topicName = ques.getCourseTopics().getTopic_Name();

		model.addAttribute("LIST", mylist);
		model.addAttribute("Question", ques);
		model.addAttribute("COUNAME", couName);
		model.addAttribute("TOPICNAME", topicName);

		return "fullView";
	}

	@GetMapping("/editquestion")
	public String EditQuestionPage(@RequestParam("questionId") String questionId, Model model) {
		Questions ques = userService.viewQuestionById(Integer.parseInt(questionId));

		List<QuestionOptions> list = userService.getQuestionOptionsByQuestionId(Integer.parseInt(questionId));

		List<String> mylist = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			String optionData = list.get(i).getOption_data();
			mylist.add(optionData);
		}

		String couName = ques.getCourses().getCourse_Name();
		String topicName = ques.getCourseTopics().getTopic_Name();
		int couId = ques.getCourses().getCourse_Id();
		int topicId = ques.getCourseTopics().getTopic_Id();

		model.addAttribute("LIST", mylist);
		model.addAttribute("Question", ques);
		model.addAttribute("COUNAME", couName);
		model.addAttribute("TOPICNAME", topicName);
		model.addAttribute("COUID", couId);
		model.addAttribute("TOPICID", topicId);
		
		return "editQuestion";
	}

	@PostMapping("/saveUpdate")
	public String saveUpdateQuestion(
			@RequestParam("questionId") String questionId,
			@RequestParam String course,
			@RequestParam String topic, 
			@RequestParam String question,
			@RequestParam String optA, 
			@RequestParam String optB, 
			@RequestParam String optC,
			@RequestParam String optD, 
			@RequestParam String correct, Model model, HttpServletRequest req) {

		String page = "";
		
		Questions ques=new Questions(Integer.parseInt(questionId),question,correct);
		
		List<QuestionOptions> opts = new ArrayList<>();

		QuestionOptions qoptA = new QuestionOptions();
		qoptA.setOption_data(optA);
		opts.add(qoptA);

		QuestionOptions qoptB = new QuestionOptions();
		qoptB.setOption_data(optB);
		opts.add(qoptB);

		QuestionOptions qoptC = new QuestionOptions();
		qoptC.setOption_data(optC);
		opts.add(qoptC);

		QuestionOptions qoptD = new QuestionOptions();
		qoptD.setOption_data(optD);
		opts.add(qoptD);
		
		userService.updateOptionsByQuestionId(Integer.parseInt(questionId), opts);
		userService.updateQuestion(ques);
		
		return "teacherHome";
	}

	@GetMapping("/showQuestions")
	public String showQuestions(@RequestParam("course") String course, @RequestParam("topic") String topic,
			HttpServletRequest req, HttpSession session, Model model) {

		List<Questions> allquestions = userService.getAllQuestions(Integer.parseInt(course), Integer.parseInt(topic));

		Map<Integer, String> mycourses = getAllCourses();
		Map<Integer, String> mytopics = getAllCourseTopics();
		session.setAttribute("COURSES", mycourses);
		session.setAttribute("TOPICS", mytopics);
		model.addAttribute("ALLQUESTIONS", allquestions);

		return "viewQuestions";

	}

	@GetMapping("/deleteQuestion")
	public String deleteQuestionById(@RequestParam("questionId") int questionId, Model model) {
		Questions ques = userService.viewQuestionById(questionId);
		model.addAttribute("Question", ques);
		return "viewQuestions";
	}

}
