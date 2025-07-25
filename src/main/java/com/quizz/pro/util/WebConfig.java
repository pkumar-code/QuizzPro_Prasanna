package com.quizz.pro.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan({"com.quizz.*"})
public class WebConfig implements WebMvcConfigurer {
	
	
	private ApiInfo getApiDetails() {
		return new ApiInfo("QuizzPro_Project",
		 "QuizzPro Project ", "1.0",
		 "Free to use ",
		 new Contact("Kumar", "https://www.quizzpro.com", "quizzpro@gmail.com"),
		 "API Under Free Licence",
		 "https://www.quizzpro.com");
		 } 

	
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
	.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
	.build().apiInfo(getApiDetails());
	 }
	
	@Bean
	public LocalSessionFactoryBean getSession(DataSource myds) {

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("org.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.use_sql_comments", "true");
		props.put("hibernate.enable_lazy_load_no_trans", "true");
		props.put("hibernate.jdbc.batch_size", 4);

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
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//enabling swagger-ui
	registry.addResourceHandler("swagger-ui.html")
	.addResourceLocations("classpath:/META-INF/resources/");
	registry.addResourceHandler("*.css").addResourceLocations("classpath:/META-INF/mycss/");
	
	} 
	
	

}
