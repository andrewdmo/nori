//package com.norialertapp.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.encoding.PasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	DataSource dataSource;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth)
//		throws Exception {
//
//		auth.jdbcAuthentication().dataSource(dataSource)
//			.passwordEncoder(passwordEncoder())
//			.usersByUsernameQuery("nori")
//			.authoritiesByUsernameQuery("nori");
//	}
//
//	@Bean
//	public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder(){
//		org.springframework.security.crypto.password.PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
//
//}