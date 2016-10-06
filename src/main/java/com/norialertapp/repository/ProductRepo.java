package com.norialertapp.repository;

import com.norialertapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by katherine_celeste on 9/30/16.
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
