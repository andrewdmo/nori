package com.norialertapp.service;

import com.norialertapp.entity.Product;
import com.norialertapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Product> listProducts(){
        List<Product> products = productRepo.findAll();
        return products;
    }

    public Product retrieveProduct(Long id){
        return productRepo.findOne(id);
    }

}