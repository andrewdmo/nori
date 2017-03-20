package com.norialertapp.repository;
import com.norialertapp.entity.QtyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by katherine_celeste on 10/12/16.
 */

@Repository
public interface QtyLevelRepo extends JpaRepository<QtyLevel, Long> {
    QtyLevel findByProductid(Long productid);

}

