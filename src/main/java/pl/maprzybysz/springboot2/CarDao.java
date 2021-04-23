package pl.maprzybysz.springboot2;

import java.util.List;

public interface CarDao {

    void saveCar(Car video);
    List<Car> findAll();
    List<Car> findAllBetweenDates(int from, int to);
}
