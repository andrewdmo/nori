package com.norialertapp.repository;
import com.norialertapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by katherine_celeste on 9/30/16.
 */

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findById(Long id);

    List<Product> findByVendorIgnoreCaseContaining(String vendor);

    List<Product> findByTitleIgnoreCaseContaining(String title);
}


