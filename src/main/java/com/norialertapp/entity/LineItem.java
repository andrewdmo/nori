package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;

/**
 * Created by katherine_celeste on 10/6/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {

    @Id
    private Long id;
    private Integer quantity;
    private Long product_id;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LineItem(){}
}
