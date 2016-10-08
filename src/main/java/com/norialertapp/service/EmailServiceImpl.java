package com.norialertapp.service;

/**
 * Email sender service implementation.
 * @author Parth Solanki
 */
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	public void sendTextMail(String from, String to, String cc, String subject, String msg) {
		this.sendTextMail(from, to, cc, null, subject, msg);
	}
	
	/**
	 * Main method for send mail.
	 * @param from
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param subject
	 * @param msg
	 */
	public void sendTextMail(String from, String to, String cc, String bcc, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		if(StringUtils.defaultString(cc).length() > 0)
			message.setCc(cc);
		if(StringUtils.defaultString(bcc).length() > 0)
			message.setBcc(bcc);
		mailSender.send(message);
	}
	
}
