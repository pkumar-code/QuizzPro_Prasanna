package com.quizz.pro.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.pro.entity.CourseTopics;
import com.quizz.pro.entity.Courses;
import com.quizz.pro.entity.QuestionOptions;
import com.quizz.pro.entity.Questions;
import com.quizz.pro.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	HibernateTemplate htemp;

	@Override
	public List<User> verifyUser(String email, String password) {

		log.info("------UserDAOImpl---verifyUser------------------");
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.and(Restrictions.eq("email", email), Restrictions.eq("password", password)));
		List<User> users = (List<User>) htemp.findByCriteria(dc);
		return users;
	}

	@Override
	public void updateUser(String email, int otp) {
		log.info("------UserDAOImpl---updateUser------------------");
		SessionFactory factory = htemp.getSessionFactory();
		Session session = factory.getCurrentSession();
		String hqlUpdate = "update User set otp = :otp where email = :email";
		int updatedEntities = session.createQuery(hqlUpdate).setInteger("otp", otp).setString("email", email)
				.executeUpdate();
	}

	@Override
	public boolean verifyOTP(int otp) {

		boolean b = false;
		log.info("------UserDAOImpl---verifyOTP------------------");
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("otp", otp));
		List<User> users = (List<User>) htemp.findByCriteria(dc);
		if (!users.isEmpty()) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	@Override
	public void forgotPWD(String email, String npassword) {
		log.info("------UserDAOImpl---forgotPWD------------------");
		SessionFactory factory = htemp.getSessionFactory();
		Session session = factory.getCurrentSession();
		String hqlUpdate = "update User set password = :npassword where email = :email";
		int updatedEntities = session.createQuery(hqlUpdate).setString("npassword", npassword).setString("email", email)
				.executeUpdate();

	}

	@Override
	public boolean verifyEmail(String email) {
		log.info("------UserDAOImpl---verifyEmail------------------");
		boolean b = false;
		SessionFactory factory = htemp.getSessionFactory();
		Session session = factory.getCurrentSession();
		String SQL = "select * from myusers where email=?";
		List<User> users = session.createNativeQuery(SQL, User.class).setParameter(1, email).getResultList();

		if (!users.isEmpty()) {
			b = true;
		}

		return b;
	}

	@Override
	public List<Courses> getCourse() {

		// List<Courses> list=htemp.loadAll(Courses.class);

		String sql = "select * from mycourses";
		SessionFactory factory = htemp.getSessionFactory();
		Session session = factory.getCurrentSession();
		List<Courses> mylist = session.createNativeQuery(sql, Courses.class).getResultList();
		return mylist;
	}

	@Override
	public List<CourseTopics> getTopics() {

		String sql = "select * from mycourse_topics";
		SessionFactory factory = htemp.getSessionFactory();
		Session session = factory.getCurrentSession();
		List<CourseTopics> mylist = session.createNativeQuery(sql, CourseTopics.class).getResultList();

		return mylist;
	}

	@Override
	public void addQuestion(Questions questions) {

		htemp.save(questions);

	}

	@Override
	public List<Questions> getAllQuestions() {

		List<Questions> list = htemp.loadAll(Questions.class);

		return list;
	}

	@Override
	public List<Questions> viewAllQuestions(int start, int total) {

		DetachedCriteria dc = DetachedCriteria.forClass(Questions.class);
		List<Questions> questionsList = (List<Questions>) htemp.findByCriteria(dc, start, total);
		return questionsList;

	}

	@Override
	public int countQuestions() {

		SessionFactory sessionFactory = htemp.getSessionFactory();
		Session session = sessionFactory.openSession();
		String sql = "select count(*) from myquestions";
		BigInteger big = (BigInteger) session.createNativeQuery(sql).uniqueResult();
		return big.intValue();

	}

	@Override
	public Questions viewQuestionById(int questionId) {
		Questions question = htemp.get(Questions.class, questionId);
		return question;
	}

	@Override
	public void updateQuestion(Questions questions) {
		htemp.update(questions);	
		return ;
	}

	@Override
	public void deleteQuestion(int questionId) {

		Questions ques = htemp.get(Questions.class, questionId);

		if (ques != null) {
			htemp.delete(ques);
		}
	}

	@Override
	public List<QuestionOptions> getQuestionOptionsByQuestionId(int question_Id) {

		SessionFactory factory = htemp.getSessionFactory();
		Session session = factory.getCurrentSession();
		String sql = "select *from myquestion_options where question_Id=?";
		List<QuestionOptions> list = session.createNativeQuery(sql, QuestionOptions.class).setParameter(1, question_Id)
				.getResultList();

		return list;
	}

	@Override
	public List<Questions> getAllQuestions(int couId, int topicId) {

		SessionFactory sessionFactory = htemp.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		String sql = "select *from myquestions where topic_Id=?1 and course_Id=?2";	
		List<Questions> list = session.createNativeQuery(sql, Questions.class)
				.setParameter(1, topicId)
				.setParameter(2, couId)	
				.getResultList();
		return list;
	}


}
