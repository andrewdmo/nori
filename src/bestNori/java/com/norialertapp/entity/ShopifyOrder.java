package com.norialertapp.entity;

/**
 * Created by katherine_celeste on 10/7/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by andrewdmo on 10/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrder {

    @Id
    private Long id;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="id")
    private List<LineItem> line_items;

    public ShopifyOrder(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LineItem> getLine_items() {
        return line_items;
    }

    public void setLine_items(List<LineItem> line_items) {
        this.line_items = line_items;
    }
}