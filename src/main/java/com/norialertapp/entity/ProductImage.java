package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductImage implements Serializable {

    @Id
    @Column(name="id")
    private Long id; // 7814648581


    private String src; // https://cdn.shopify.com/s/files/1/0711/7863/products/Andean-Cross-with-Black-Platafina.jpg?v=1455850375",

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }


    public ProductImage(){

    }
}
