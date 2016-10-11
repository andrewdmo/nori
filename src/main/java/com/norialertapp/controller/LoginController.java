package com.norialertapp.controller;

import com.norialertapp.entity.Users;
import com.norialertapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by katherine_celeste on 10/11/16.
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

//    @RequestParam(value = "error", required = false) String error,
//    @RequestParam(value = "logout", required = false) String logout,

    //Spring Security sees this :
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String userLogin(String password, String username) {

        Users user = userService.findByEmail(username); //username = email
        if(userService.passwordMatch(password, user.getPassword())){
            return "dashboard";
        }
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", "Invalid username and password!");
//        }
//
//        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
//        }
//        model.setViewName("login");

        return "errorPg"; // Uh oh....
                    //Something went wrong. Please navigate back to the previous page.
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.GET)
    public String createAccount(Model model) {
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String accountCreated(String firstName, String lastName, String email, String password,
                                 String confirmPassword, Model model) {
        Users user = new Users();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);

        // make sure user has not registered in the past
        if(userService.findByEmail(email)==null) {
            try {
                userService.saveUser(user);
                return "dashboard";
            } catch (Exception e) {

            }
        }
            return "errorPg";
    }

    @RequestMapping(value = "/emailTemplate", method = RequestMethod.GET)
    public String emailTemplate(Model model) {
        return "email-template";
    }
}