package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import javax.persistence.Entity;
        import javax.persistence.Id;
/**
 * Created by andrewdmo on 10/12/16.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatchHook {
    @Id
    private Long id;
    private String email;
    //private LineItem lineItem;
    public CatchHook() {
    }
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
//    public CatchHook(long id, String email) {
//        this.id = id;
//        this.email = email;
//        //this.lineItem = lineItem;
//    }
//
//    public long getId() {
//        //System.out.println(id);
//        return id;
//    }
//
//    public String getEmail() {
//        System.out.println(email);
//        return email;
//    }
//        public LineItem getLineItem();
//            return LineItem;
//    }