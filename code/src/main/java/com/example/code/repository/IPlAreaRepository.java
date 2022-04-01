package com.example.code.repository;

import com.example.code.entity.Area;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Repository class for Area.
 * Database Used H2.
 * For properties please refer to application.properties file.
 */
public interface IPlAreaRepository extends JpaRepository<Area,Long> {

  /**
   * Retruns the area for a particular postcode.
   * @param postCode
   * @return
   */
  Area findByPostCode(long postCode);

  /**
   * Returns list of areas between start and end pincode( both inclusive )
   * @param start
   * @param end
   * @return
   */
  @Query("from Area where post_code >=:start and post_code <=:end")
  List<Area> findWithinRange(@Param("start") long start, @Param("end")  long end);
}
