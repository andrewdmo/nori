package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import javax.persistence.Entity;
import java.sql.Date;
import java.util.List;

/**
 * Created by andrewdmo on 10/12/16.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatchHook {
    @Id
    private Long id;

    private String cancel_reason;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "catchHookID")
    private List<LineItem> line_items;

    public CatchHook() {
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

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