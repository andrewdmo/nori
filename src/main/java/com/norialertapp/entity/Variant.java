package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variant {

    @Id
    private Long id; // 10909727301

    private Long productID; // 3709610885
    private Integer inventoryQty; // 1

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Integer getInventoryQty() {
        return inventoryQty;
    }

    public void setInventoryQty(Integer inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    public Variant(){

    }
}
