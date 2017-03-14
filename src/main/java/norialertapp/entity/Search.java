package norialertapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 10/12/16.
 */
public class Search {

    @Id
    @GeneratedValue
    private Long id;
    private Long productID;
    private String vendorName;
    private String itemName;
    private String qtyLevel;

    public Search() {
    }

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

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQtyLevel() {
        return qtyLevel;
    }

    public void setQtyLevel(String qtyLevel) {
        this.qtyLevel = qtyLevel;
    }
}
