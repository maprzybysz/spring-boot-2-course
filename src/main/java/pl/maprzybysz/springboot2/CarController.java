package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    //@Autowired
    private CarService carService;

    @Autowired //recommended way, default annotation
    public CarController(CarService carService) {
        this.carService = carService;
    }

//    @Autowired
//    public void setCarService(CarService carService) {
//        this.carService = carService;
//    }

    @GetMapping
    public List<Car> get(){
        return carService.getCars();
    }
}
