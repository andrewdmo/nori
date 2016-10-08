package com.norialertapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 10/7/16.
 */

@Entity
public class level {

    @Id
    @GeneratedValue
    private Long id;

    private String customLevel;

    private Integer quantity;
}
