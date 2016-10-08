//package com.norialertapp.entity;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by katherine_celeste on 10/8/16.
// */
//@Entity
//@Table(name = "users")
//public class Users implements Serializable, UserDetails {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//
//    private String firstname;
//
//    private String lastname;
//
//    private String password;
//
//    @Transient
//    private String confirmPassword;
//
//    private boolean isEmailVerfiy;
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    private String email;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
//        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return grantedAuths;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isEnabled() {
//        return this.isEmailVerfiy;
//    }
//
//    public boolean isEmailVerfiy() {
//        return isEmailVerfiy;
//    }
//
//    public void setEmailVerfiy(boolean emailVerfiy) {
//        isEmailVerfiy = emailVerfiy;
//    }
//}