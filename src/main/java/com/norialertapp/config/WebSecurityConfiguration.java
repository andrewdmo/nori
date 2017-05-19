package com.norialertapp.config;

/**
 * Created by andrewdmo on 4/9/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Qualifier("dataSource")
    private DataSource dataSource;

    //    @Autowired
    private UserDetailsService userDetailsService;

    private UserAccountDao userAccountDao;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/css/**", "/images/**", "/js/**", "/", "/index", "/createAcct", "/loginForm").permitAll()
//            .antMatchers("/**").hasRole("USER") //saving for later when Roles ok
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll()
//            .usernameParameter("email")
//            .passwordParameter("password")
//            .defaultSuccessUrl("/dashboard")
            .and()
            .logout()
// .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //confirm Logout
            .logoutSuccessUrl("/login?logout")
            .permitAll();
//            .and()
//            .exceptionHandling()
//            .accessDeniedHandler();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("test@test").password("test").roles("USER");
//            .jdbcAuthentication()
//            .dataSource(dataSource)
//            .and()
//            .userDetailsService(userDetailsService)
//            .and()
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
            .userDetailsService(userAccountDao)
//            .userDetailsService(this.userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
}