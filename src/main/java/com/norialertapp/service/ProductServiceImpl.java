package com.norialertapp.service;

import com.norialertapp.entity.Product;
import com.norialertapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by katherine_celeste on 10/5/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;


    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }


}
