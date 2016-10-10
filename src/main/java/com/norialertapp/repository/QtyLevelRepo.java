package com.norialertapp.repository;

import com.norialertapp.entity.QtyLevel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by katherine_celeste on 10/8/16.
 */
public interface QtyLevelRepo extends JpaRepository<QtyLevel, Long> {
    QtyLevel findByProductid(Long productid);
}
