package com.norialertapp.repository;

import com.norialertapp.entity.CatchHook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by katherine_celeste on 10/14/16.
 */

@Repository
public interface CatchHookRepo extends JpaRepository<CatchHook, Long>{
}
