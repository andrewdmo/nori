package norialertapp.service;

import norialertapp.entity.Product;

import java.util.List;

/**
 * Created by katherine_celeste on 10/5/16.
 */
public interface ProductService {

     void saveProduct(Product product);
     List<Product> listProducts();
}
