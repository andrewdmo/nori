package com.norialertapp.service;

import com.norialertapp.utility.Constants;
import com.norialertapp.utility.EncryptDecryptUtils;
import com.norialertapp.utility.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;

/**
 * Created by katherine_celeste on 10/8/16.
 */
@Service
public class EmailSenderService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine;


    public void sendRegistrationSuccessEmail(String name, String email, String verifyEmailLink, String serverUrl) {

        final Context ctx = new Context(Locale.US);
        ctx.setVariable("fullname", name);
        String encryptDate = EncryptDecryptUtils.encrypt(Utils.currentStringDate());
        ctx.setVariable("verifyEmailLink", verifyEmailLink+"&d="+encryptDate);
        final String htmlContent = templateEngine.process("registration_mail", ctx);

        emailService.sendTextMail(Constants.FROM, email, null,"Welcome to nori", htmlContent);
    }
}
