package pl.maprzybysz.springboot2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.maprzybysz.springboot2.model.Car;

@Controller
public class CarController {

    @GetMapping("/car")
    public String get(Model model){
        Car car = new Car("BMW", "M3");
        model.addAttribute("name", "Mateusz");
        model.addAttribute("car", car);
        return "hello";
    }
}
