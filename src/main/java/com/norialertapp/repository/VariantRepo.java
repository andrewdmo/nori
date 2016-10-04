package com.norialertapp.repository;

import com.norialertapp.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by katherine_celeste on 9/30/16.
 */
public interface VariantRepo extends JpaRepository<Variant, Integer> {
}
