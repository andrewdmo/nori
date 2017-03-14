package norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variant implements Serializable {

    @Id
    private Long id; // 10909727301

    //  private Long product_id; // 3709610885
    private Integer inventory_quantity; // 1

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(Long product_id) {
//        this.product_id = product_id;
//    }

    public Integer getInventory_quantity() {
        return inventory_quantity;
    }

    public void setInventory_quantity(Integer inventory_quantity) {
        this.inventory_quantity = inventory_quantity;
    }

    public Variant() {

    }
}
