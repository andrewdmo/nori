package com.norialertapp.service;

import com.norialertapp.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by katherine_celeste on 10/8/16.
 */

@Service
public interface UserService {

    User findByEmail(String email);

    void saveUser(User user);

//    boolean passwordMatch(String password, String dbPassword);

//    turned off to match Impl
//    boolean isEnabled();
}