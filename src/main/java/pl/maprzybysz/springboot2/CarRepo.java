package pl.maprzybysz.springboot2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findCarsByColor(Color color);
    List<Car> findCarsByColorAndMark(Color color, String mark);
}
