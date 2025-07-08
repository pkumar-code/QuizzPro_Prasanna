package com.quizz.pro.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.pro.Entity.User;

@Repository
@Profile("dev")
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

}
