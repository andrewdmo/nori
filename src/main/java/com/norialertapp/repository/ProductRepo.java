package com.norialertapp.repository;

import com.norialertapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by katherine_celeste on 9/30/16.
 */
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
