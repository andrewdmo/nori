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

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    UserServiceImpl userServiceImpl;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/css/**", "/images/**", "/", "/index", "/createAcct", "/loginForm").permitAll()
            .anyRequest().authenticated() //keeps blocking CSS??
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll()
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/dashboard")
            .and()
            .logout()
// .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //confirm Logout
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
//            .userDetailsService()
//            .and()
            .jdbcAuthentication()
            .dataSource(dataSource)
            .withUser("test@test").password("test").roles("USER");
//            .and()
//            .inMemoryAuthentication()
//            .withUser("test@test").password("test").roles("USER");

    }
}