package com.norialertapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 10/7/16.
 */

@Entity
public class Level {

    @Id
    @GeneratedValue
    private Long id;

    private String customLevel;

    private Integer quantity;

    public Level(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomLevel() {
        return customLevel;
    }

    public void setCustomLevel(String customLevel) {
        this.customLevel = customLevel;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
