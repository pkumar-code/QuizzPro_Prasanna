package com.quizz.pro.template;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplate {

	@Autowired
	JavaMailSender mailSender;

	public void sendMail(String from, String to, String subject, String body) {

		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
			mailMsg.setFrom(from);
			mailMsg.setTo(to);
			mailMsg.setSubject(subject);
			mailMsg.setText(body, true);
			mailSender.send(mimeMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
