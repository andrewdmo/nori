package com.norialertapp.repository;

import com.norialertapp.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by katherine_celeste on 10/13/16.
 */

@Repository
public interface LevelRepo extends JpaRepository<Level, Long> {

    Level findByCustomLevelAndId(String customLevel, Long id);
}
