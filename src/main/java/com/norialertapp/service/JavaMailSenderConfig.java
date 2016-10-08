package com.norialertapp.service;

/**
 * Java mail sender configuration class
 *
 */
import java.util.Properties;

import com.norialertapp.utility.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class JavaMailSenderConfig {
	
	@Bean 
	public JavaMailSender getJavaMailSenderImpl(){
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties props = new Properties();
		props.put("mail.smtp.host", Constants.MAIL_HOST);
		props.put("mail.smtp.socketFactory.port", Constants.MAIL_SOCKET_PORT);
		props.put("mail.smtp.socketFactory.class", Constants.MAIL_SOCKET_CLASS);
		props.put("mail.smtp.auth", Constants.MAIL_AUTH);
		props.put("mail.smtp.port", Constants.MAIL_SMTP_PORT);
        javaMailSender.setJavaMailProperties(props);
        javaMailSender.setUsername(Constants.MAIL_USERNAME);
        javaMailSender.setPassword(Constants.MAIL_PASSWORD);
        return javaMailSender;
    }
    
}