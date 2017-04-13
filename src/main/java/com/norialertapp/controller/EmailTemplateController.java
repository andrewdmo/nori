package com.norialertapp.controller;

import com.norialertapp.entity.EmailContent;
import com.norialertapp.repository.EmailContentRepo;
import com.norialertapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by katherine_celeste on 10/17/16.
 */

@Controller
public class EmailTemplateController {

    @Autowired
    EmailContentRepo emailContentRepo;

    @Autowired
    UserRepo userRepo;

    @RequestMapping(path = "/emailTextModifications", method = RequestMethod.POST)
    public String emailTextMods(Model model) {
        EmailContent content = new EmailContent();

        if (emailContentRepo.findAll() != null) {
            emailContentRepo.deleteAll();
        }

        String email = userRepo.findAll().get(0).getEmail();

        content.setToField("");
        content.setFromField(email); // use emailAddress to lookup in other classes
        content.setBodyField("");
        content.setSubjectField("");

        emailContentRepo.save(content);

        model.addAttribute("content", content);

        return "emailTemplate2";
    }

    @RequestMapping(value = "/emailTemplate", method = RequestMethod.GET)
    public String emailTemplate(Model model) {
        return "emailTemplate";
    }

    @RequestMapping(path = "/emailTemplate", method = RequestMethod.POST)
    public String emailTemplate(String toField, String fromField, Long id, String bodyField, String subjectField, Model model) {

        EmailContent content = emailContentRepo.findOne(id);

        content.setToField(toField);
        content.setFromField(fromField); // use emailAddress to lookup in other classes
        content.setBodyField(bodyField);
        content.setSubjectField(subjectField);

        emailContentRepo.save(content);

        model.addAttribute("content", content);

        return "emailTemplate3";
    }
}
