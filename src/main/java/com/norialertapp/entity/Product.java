package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    private Long id; // 3709610885

    private String title; // "Andean Cross | Sterling Silver Earrings with Black Onyx"
    private String vendor; // "Platafina"
   // private List<Variant> variants; // list of product variants - all products on this store have one variant

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
