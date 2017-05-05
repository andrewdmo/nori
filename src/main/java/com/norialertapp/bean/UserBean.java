//
//package com.norialertapp.bean;
//
//import com.norialertapp.entity.Role;
//import org.hibernate.validator.constraints.NotEmpty;
//
//import javax.validation.constraints.NotNull;
//
//public class UserBean {
//    @NotEmpty
//    private String firstname = "";
//
//    @NotEmpty
//    private String lastname = "";
//
//    @NotEmpty
//    private String username = ""; //email
//
//    @NotEmpty
//    private String password = "";
//
//    @NotEmpty
//    private String passwordrepeated = "";
//
//    @NotNull
//    private Role role = Role.USER;
//
//    public String getusername() {
//        return username;
//    }
//
//    public void setusername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPasswordRepeated() {
//        return passwordrepeated;
//    }
//
//    public void setPasswordRepeated(String passwordRepeated) {
//        this.passwordrepeated = passwordRepeated;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
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
//}