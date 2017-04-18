package com.norialertapp.config;

/**
 * Created by andrewdmo on 4/9/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()

            .antMatchers("/", "/index", "/createAcct", "/loginForm", "/css/**").permitAll()
            .anyRequest().authenticated() //keeps blocking CSS
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .failureUrl("/login?error")
            .defaultSuccessUrl("/dashboard")
            .and()
            .logout()
            .permitAll()
// .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //confirm Logout
            .logoutSuccessUrl("/login?logout");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("test@test").password("test").roles("USER");
    }

}