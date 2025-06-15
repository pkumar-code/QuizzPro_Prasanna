package com.quizz.pro.Util;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan({"com.quizz.pro.*"})
public class WebConfig {
	
	@Bean
	public ViewResolver getView() {
		
		InternalResourceViewResolver view=new InternalResourceViewResolver();
		
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/myjsps/");
		view.setSuffix(".jsp");
		System.out.println("------------------ViewResolver---------------");
		return view;
		
	}
	
	@Bean
	public LocalSessionFactoryBean getSession(DataSource myds) {

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("org.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.use_sql_comments", "true");

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setDataSource(myds);
		sessionFactory.setPackagesToScan("com.quizz.pro.*");

		return sessionFactory;
	}

	@Bean
	public HibernateTemplate getHT(SessionFactory sf) {
		return new HibernateTemplate(sf);
	}

	@Bean
	public PlatformTransactionManager getTXManger(SessionFactory sf) {

		return new HibernateTransactionManager(sf);
	}
	
	
	@Bean
	public JavaMailSender javaMailSenderImpl() {
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost("smtp.gmail.com");
	mailSender.setPort(465);
	mailSender.setUsername("pkumar.c028@gmail.com");
	mailSender.setPassword("PKumar@123");
	Properties prop = mailSender.getJavaMailProperties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.socketFactory.port", "465");
	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.startssl.enable", "true");
	return mailSender;
	}
	
	

}
