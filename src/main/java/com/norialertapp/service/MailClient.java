package com.norialertapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;


/**
 * Created by katherine_celeste on 10/9/16.
 */
@Service
public class MailClient {

    private JavaMailSender mailSender;

    @Autowired
    public MailClient(@SuppressWarnings("SpringJavaAutowiringInspection") JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }

    //can undo final designation:
    public void send(final String recipient, final String subject, final String body) {
        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(javax.mail.internet.MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setFrom("peruvianplatafinaalerts@gmail.com");
                messageHelper.setTo(recipient);
                messageHelper.setSubject(subject);
                messageHelper.setText(body);
            }
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }

}