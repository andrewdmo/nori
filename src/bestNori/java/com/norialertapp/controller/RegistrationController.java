//package com.norialertapp.controller;
//import com.norialertapp.entity.Users;
//import com.norialertapp.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
///**
// * Created by katherine_celeste on 10/8/16.
// */
//@Controller
//public class RegistrationController {
//
//
//    @Autowired
//    private UserService userService;
//
//
//
//     @RequestMapping(path = "/sign-up" ,method = RequestMethod.GET)
//     public String userSignupPage(Model model) {
//
//         model.addAttribute("users", new Users());
//         return "sign-up";
//     }
//
//     @RequestMapping(value = "/sign-up",method = RequestMethod.POST)
//     public String saveUser(@ModelAttribute("users") Users users,Model model) {
//
//         //first check for password or conf pass - see if it matches
//
//         if(!users.getPassword().equals(users.getConfirmPassword())) {
//             model.addAttribute("users",users);
//             model.addAttribute("error","Password and confrim password is not match");
//             return "sign-up";
//         }
//
//         //check if email exists or not
//         Users savedUser = userService.findByEmail(users.getEmail());
//         if(savedUser != null) {
//             //users is not equal to null meaans user with this email id is already exist
//             model.addAttribute("users",users);
//             model.addAttribute("error","This email is already exist with us.");
//             return "sign-up";
//         }
//
//         try {
//             // now save
//             userService.saveUser(users);
//         } catch(Exception e) {
//             model.addAttribute("users",users);
//             model.addAttribute("error","Internal server error , please try agian");
//             return "sign-up";
//         }
//
//         model.addAttribute("success","You will receive an email to activate your account. If you don't find in your Inbox, please check your spam/junk mail as well.");
//         return "success";
//     }
//}
