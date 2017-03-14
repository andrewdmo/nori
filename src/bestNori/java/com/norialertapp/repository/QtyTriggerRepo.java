package com.norialertapp.repository;

import com.norialertapp.entity.QtyAlertTriggerLevel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by katherine_celeste on 10/10/16.
 */
public interface QtyTriggerRepo extends JpaRepository<QtyAlertTriggerLevel, Long> {
    QtyAlertTriggerLevel findByProductId(Long productid);

}
