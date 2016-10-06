package com.norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 10/6/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class KOrder {

    @Id
    private Long id;

    private LineItem[] items;
}
