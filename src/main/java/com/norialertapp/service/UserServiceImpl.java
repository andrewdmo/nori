//package com.norialertapp.service;
//
//import com.norialertapp.entity.Users;
//import com.norialertapp.repository.UserRepo;
//import com.norialertapp.utility.Constants;
//import com.norialertapp.utility.EncryptDecryptUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
///**
// * Created by katherine_celeste on 10/8/16.
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private EmailSenderService  emailSenderService;
//
//    @Override
//    public Users findByEmail(String email) {
//        return userRepo.findByEmail(email);
//    }
//
//    @Override
//    public void saveUser(Users user){
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        user.setEmailVerfiy(false);
//        Users savedUser = userRepo.save(user);
//
//        String encryptedUserId = EncryptDecryptUtils.encrypt(String.valueOf(savedUser.getId()));
//        // send email to user activate his account
//        String verifyEmailLink = Constants.ROOT_URL + "activate" + "?token=" + encryptedUserId;
//        emailSenderService.sendRegistrationSuccessEmail(user.getFirstname(), user.getEmail(), verifyEmailLink, Constants.ROOT_URL);
//    }
//}
