package kh.aditya.first.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {

    // here we get almost all the methods
    // (delete, find etc) pre built

    List<Run> findByLocation(Location location);

    @Query("""
            SELECT * FROM run
            WHERE distance >= :min
            AND distance <= :max
            """)
    List<Run> findByDistance(
            @Param("min") double min,
            @Param("max") double max
    );
}