package com.norialertapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 10/10/16.
 */

@Entity
public class QtyAlertTriggerLevel {

    @Id
    @GeneratedValue
    private Long id;

    private String qtyTrigger;

    private Long productId;

    public QtyAlertTriggerLevel() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQtyTrigger() {
        return qtyTrigger;
    }

    public void setQtyTrigger(String qtyTrigger) {
        this.qtyTrigger = qtyTrigger;
    }
}
