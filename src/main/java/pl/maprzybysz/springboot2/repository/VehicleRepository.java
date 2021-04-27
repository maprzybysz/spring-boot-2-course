package pl.maprzybysz.springboot2.repository;

import org.springframework.data.repository.CrudRepository;
import pl.maprzybysz.springboot2.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Iterable<Vehicle> findAllByColor(String color);
}
