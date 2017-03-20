package com.norialertapp.service;

import com.norialertapp.entity.Users;

/**
 * Created by katherine_celeste on 10/8/16.
 */
public interface UserService {

    Users findByEmail(String email);

     void saveUser(Users users);

    boolean passwordMatch(String password, String dbPassword);
}
