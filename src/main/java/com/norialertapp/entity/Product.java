package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    @Column(name = "id")
    private Long id; // 3709610885

    private String title; // "Andean Cross | Sterling Silver Earrings with Black Onyx"
    private String vendor; // "Platafina"

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "productID")
    private List<Variant> variants; // list of product variants - all products on this store have one variant

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "productID")
    private List<ProductImage> images;

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public String getTitle(
    ) {
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Product() {

    }

}
