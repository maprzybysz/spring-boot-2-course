package pl.maprzybysz.springboot2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.maprzybysz.springboot2.model.Car;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/car")
    public String get(Model model){
        Car car1 = new Car("BMW", "M2");
        Car car2 = new Car("BMW", "M3");
        Car car3 = new Car("BMW", "M4");
        Car car4 = new Car("BMW", "M5");
        List<Car> cars = Arrays.asList(car1, car2, car3, car4);

        model.addAttribute("cars", cars);

        return "car";
    }
}
