package pl.maprzybysz.springboot2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findCarsByColor(Color color);
    List<Car> findCarsByColorAndMark(Color color, String mark);
    @Query(value = "SELECT * FROM cars WHERE cars.model = :model", nativeQuery = true)
    List<Car> findCarsByModel(@Param("model") String model);
}
