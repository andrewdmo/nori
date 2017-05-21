package com.norialertapp.service;

import com.norialertapp.entity.User;

/**
 * Created by katherine_celeste on 10/8/16.
 */

public interface UserService {

    User findByEmail(String email);

    void saveUser(User user);

//    boolean passwordMatch(String password, String dbPassword);

    boolean isEnabled();
}