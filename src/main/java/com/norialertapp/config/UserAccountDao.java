package com.norialertapp.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Component
public class UserAccountDao implements UserDetailsService {

    private UserDetails userDetails;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        // Execute database query to retrieve the user details.

        //from original:
//        userRepo.findByUsername(email)

        userDetails.getUsername();
        return userDetails;
    }
}
