package com.norialertapp.controller;

import com.norialertapp.entity.EmailContent;
import com.norialertapp.repository.EmailContentRepo;
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

    @RequestMapping(path = "/emailTextModifications", method = RequestMethod.POST)
    public String emailTextMods(){
        return "emailTemplate2";
    }

    @RequestMapping(path = "/emailTemplate", method = RequestMethod.POST)
    public String emailTemplate(String toField, String fromField, String bodyField, String subjectField, Model model){

        EmailContent content;

        if(emailContentRepo.findByFromField(fromField)==null){
        content = new EmailContent();}
        else{ //override
            content = emailContentRepo.findByFromField(fromField);
        }

            content.setToField(toField);
            content.setFromField(fromField); // use emailAddress to lookup in other classes
            content.setBodyField(bodyField);
            content.setSubjectField(subjectField);

            emailContentRepo.save(content);

            model.addAttribute("content", content);

        return "emailTemplate3";
    }
}
