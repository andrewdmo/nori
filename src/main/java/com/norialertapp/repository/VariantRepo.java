package com.norialertapp.repository;

import com.norialertapp.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by katherine_celeste on 9/30/16.
 */
@Repository
public interface VariantRepo extends JpaRepository<Variant, Long> {
  //  List<Long> findAll(List<Long> productid);
}
