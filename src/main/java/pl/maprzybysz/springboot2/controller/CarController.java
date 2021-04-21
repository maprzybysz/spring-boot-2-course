package pl.maprzybysz.springboot2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.maprzybysz.springboot2.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars;

    public CarController() {
        Car car1 = new Car("BMW", "M2");
        Car car2 = new Car("BMW", "M3");
        Car car3 = new Car("BMW", "M4");
        Car car4 = new Car("BMW", "M5");
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @GetMapping("/car")
    public String get(Model model){
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        cars.add(car);
        return "redirect:/car";
    }
    @GetMapping("/delete-car/{id}")
    public String deleteCar(@PathVariable int id){
        cars.remove(id);
        return "redirect:/car";
    }
    @GetMapping("/edit-car/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        Car car = cars.get(id);
        model.addAttribute("editCar", car);
        model.addAttribute("id", id);
        return "car-update";
    }
    @PostMapping("/update-car")
    public String updateCar(@RequestParam int id, @ModelAttribute Car car){
        Car editCar = cars.get(id);
        editCar.setMark(car.getMark());
        editCar.setModel(car.getModel());
        return "redirect:/car";
    }
}
