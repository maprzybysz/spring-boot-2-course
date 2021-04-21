package pl.maprzybysz.springboot2.manager;

import org.springframework.stereotype.Service;
import pl.maprzybysz.springboot2.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager {

    private List<Car> carList;

    public CarManager() {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", "M3"));
        carList.add(new Car("BMW", "M2"));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car){
        carList.add(car);
    }
}
