package com.norialertapp.entity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by katherine_celeste on 9/30/16.
 */

@Entity
public class QtyLevel {

    @Id
    @GeneratedValue
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Long id;

    @Column (unique = true)
    private Long productid;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="qtyLevelID")
    private List<Level> productLevels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public List<Level> getProductLevels() {
        return productLevels;
    }

    public void setProductLevels(List<Level> productLevels) {
        this.productLevels = productLevels;
    }

}
