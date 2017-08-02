package com.norialertapp.service;

import com.norialertapp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by andrewdmo on 5/21/17.
 */
abstract class NoriUserPrincipal implements UserDetails {

    private User user;

    public NoriUserPrincipal(User user) {
        this.user = user;
    }

    public boolean isEnabled() {
        return user.getEnabled();
}

    public String getUsername() {
        return user.getUsername();
    }

    public String getPassword() {
        return this.password;
    }
}
