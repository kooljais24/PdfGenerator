package Generator.Pdf.generator.repository;

import Generator.Pdf.generator.models.entity.UserActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ActivityTableRepository extends JpaRepository<UserActivityEntity, Integer> {
    UserActivityEntity findByUserId(Integer id);

    List<UserActivityEntity> findAllByEndTimeBetween(Timestamp time1, Timestamp time2);
}
