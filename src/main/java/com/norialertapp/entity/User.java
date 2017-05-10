package com.norialertapp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by katherine_celeste on 10/8/16.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, updatable = false)
//    private long id;

    @Id
    @Column
    private String username;

    @Column
    private String password;

    //need to instantiate for below:
    private boolean enabled = false;

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    // getters & setters below!!


//    @Column
//    private String firstname;
//
//    @Column
//    private String lastname;

//    older:
//    @Column(name = "enabled")
//    public boolean isEnabled() {
//        return UserServiceImpl.findByEmail(username);
//    };

//    @Column(name = "role"/*, nullable = false*/)
//    @Enumerated(EnumType.STRING)
//    Role role;


//    public boolean isEmailVerify() {
//        return isEmailVerify;
//    }

//    public void setEmailVerify(boolean emailVerify) {
//        isEmailVerify = emailVerify;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    @OneToOne(cascade = CascadeType.ALL)
    EmailContent emailText;

    @Transient //don't store in db
    private String confirmPassword;

//    private boolean isEmailVerify;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

//    public String getUsername() {
//        return username;
//    }


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


    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
//        grantedAuths.add(new ERROR: relation "authorities" does not existSimpleGrantedAuthority("ROLE_ADMIN"));
//        return grantedAuths;
//    }

    //    @Override

    //    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//

}