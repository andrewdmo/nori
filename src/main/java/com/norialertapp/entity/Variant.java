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
    private Integer id; // 10909727301

    private Integer productID; // 3709610885
    private Integer inventoryQty; // 1

    public Variant(){

    }
}
