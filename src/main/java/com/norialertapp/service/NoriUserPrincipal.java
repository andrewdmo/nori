package com.norialertapp.service;

import com.norialertapp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by andrewdmo on 5/21/17.
 */
public class NoriUserPrincipal implements UserDetails {

    private User user;

    public NoriUserPrincipal(User user) {
        this.user = user;
    }
}
