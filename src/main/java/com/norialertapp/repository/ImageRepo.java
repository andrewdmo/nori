package com.norialertapp.repository;

import com.norialertapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by katherine_celeste on 9/30/16.
 */
@Repository
public interface ImageRepo extends JpaRepository <Image, Integer> {
}
