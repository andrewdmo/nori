package com.norialertapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {


    private String authority;

    @Id
    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }
}