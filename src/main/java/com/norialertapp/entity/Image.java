package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    @Id
    private Integer id; // 7814648581

    private Integer productID; //3709610885
    private Integer position; // 1
    private String src; // https://cdn.shopify.com/s/files/1/0711/7863/products/Andean-Cross-with-Black-Platafina.jpg?v=1455850375",

    public Image(){

    }
}
