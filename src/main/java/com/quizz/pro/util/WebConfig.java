package com.quizz.pro.util;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.google.common.base.Predicates;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
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
	

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//enabling swagger-ui
	registry.addResourceHandler("swagger-ui.html")
	.addResourceLocations("classpath:/META-INF/resources/");
	registry.addResourceHandler("*.css").addResourceLocations("classpath:/META-INF/mycss/");
	
	} 
	
	

}
