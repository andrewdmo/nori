package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    @Id
    private Long id; // 7814648581

   // @OneToOne (cascade= CascadeType.ALL)
    private Long productID; //3709610885

    private Integer position; // 1
    private String src; // https://cdn.shopify.com/s/files/1/0711/7863/products/Andean-Cross-with-Black-Platafina.jpg?v=1455850375",

    public Image(){

    }
}
