package pl.maprzybysz.springboot2.service;


import pl.maprzybysz.springboot2.model.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAllVehicles();

    Vehicle findVehicleById(Long id);

    List<Vehicle> findAllVehiclesByColor(String color);

    Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle>  saveVehicleList(List<Vehicle> vehicleList);

}
