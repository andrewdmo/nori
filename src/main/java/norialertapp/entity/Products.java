package norialertapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by katherine_celeste on 10/3/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {

    private Product[] products;

    public Products(){

    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
