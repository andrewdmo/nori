package com.norialertapp.controller;
import com.norialertapp.entity.QtyAlertTriggerLevel;
import com.norialertapp.service.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;

/**
 * Created by katherine_celeste on 10/9/16.
 */

@Controller
public class MailController {
    //
    @Autowired
    private MailClient mailClient;

//    @Autowired
//    private QtyAlertTriggerLevel qtyAlertTriggerLevel;

    @RequestMapping(path="/mail", method= RequestMethod.POST)
    public String sendMail(Model model, String high, String low, String out) throws MessagingException {

//        QtyAlertTriggerLevel levelSelected = new QtyAlertTriggerLevel();
////        if(high!=null){
////            levelSelected
////        }

        mailClient.send("kceleste35@gmail.com", "Inventory Alert: Items Low/Out of Stock", "You currently have one or more items out" +
                "of stock. Cheers! -Nori");

        return "success";
    }
}


