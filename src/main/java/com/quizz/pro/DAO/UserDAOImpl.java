package com.quizz.pro.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.pro.Entity.User;

@Repository
@Transactional
public class UserDAOImpl  implements UserDAO{
	
	@Autowired
	HibernateTemplate htemp;
	
	@Override
	public List<User> verifyUser(String email, String password) {
 
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.and(Restrictions.eq("email",email),Restrictions.eq("password", password)));
           List<User> users=  (List<User>) htemp.findByCriteria(dc);
		return users;
	}

	@Override
	public void updateUser(String email,int otp) {
	
		SessionFactory factory=htemp.getSessionFactory();
		Session session=factory.getCurrentSession();
		 String hqlUpdate = "update User set otp = :otp where email = :email";
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setInteger("otp", otp)
		        .setString( "email", email )
		        .executeUpdate();
	}

	@Override
	public boolean  verifyOTP(int otp) {
			
		boolean b=false;	
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("otp", otp));
           List<User> users=  (List<User>) htemp.findByCriteria(dc);
           if(!users.isEmpty()) {
        	   b=true;
           }else {
        	   b=false;
           }
		return b;		
	}

}
