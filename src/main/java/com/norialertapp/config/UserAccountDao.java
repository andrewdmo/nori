package com.norialertapp.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserAccountDao implements UserDetailsService {

    private UserDetails userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Execute database query to retrieve the user details.

        //from original:
//        userRepo.findByUsername(email)

        userDetails.getUsername();
        return userDetails;
    }
}
