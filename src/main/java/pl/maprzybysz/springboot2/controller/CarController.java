package pl.maprzybysz.springboot2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.maprzybysz.springboot2.model.Car;

import java.util.ArrayList;
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

    @GetMapping("/cars")
    public String getCars(Model model){
        model.addAttribute("cars", cars);
        return "cars";
    }
    @GetMapping("/car")
    public String getCars(@RequestParam int id, Model model){
        Car car = cars.get(id);
        model.addAttribute("findCar", car);
        model.addAttribute("id", id);
        return "car";
    }
    @GetMapping("/car-add")
    public String getAddView(Model model){
        model.addAttribute("newCar", new Car());
        return "car-add";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        cars.add(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete-car/{id}")
    public String deleteCar(@PathVariable int id){
        cars.remove(id);
        return "redirect:/cars";
    }
    @GetMapping("/edit-car/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        Car car = cars.get(id);
        model.addAttribute("editCar", car);
        model.addAttribute("id", id);
        return "car-update";
    }
    @PostMapping("/update-car/{id}")
    public String updateCar(@PathVariable int id, @ModelAttribute Car car){
        Car editCar = cars.get(id);
        editCar.setMark(car.getMark());
        editCar.setModel(car.getModel());
        return "redirect:/cars";
    }
}
