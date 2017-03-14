package norialertapp.repository;

import norialertapp.entity.EmailContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by katherine_celeste on 10/17/16.
 */

@Repository
public interface EmailContentRepo extends JpaRepository <EmailContent, Long>{
 EmailContent findByFromField(String fromField);
}
