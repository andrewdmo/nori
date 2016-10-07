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

   // @OneToOne (cascade= CascadeType.ALL)
    private Long product_id; //3709610885

    private String src; // https://cdn.shopify.com/s/files/1/0711/7863/products/Andean-Cross-with-Black-Platafina.jpg?v=1455850375",

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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
