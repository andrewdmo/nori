package com.norialertapp.repository;

import com.norialertapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by katherine_celeste on 9/30/16.
 */
public interface ImageRepo extends JpaRepository <Image, Integer> {
}
