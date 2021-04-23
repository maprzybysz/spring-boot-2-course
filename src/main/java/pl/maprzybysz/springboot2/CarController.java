package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping
    public String getIndex(){
        return "index";
    }
    @GetMapping("/add")
    public String addCar(Model model){
        model.addAttribute("newCar", new Car());
        return "addCar";
    }
    @GetMapping("/cars")
    public String getAll(Model model){
        List<Car> carList = carDao.findAll();
        model.addAttribute("carList", carList);
        return "cars";
    }
    @GetMapping("/findcars")
    public String getFindCars(Model model, @RequestParam int from, @RequestParam int to){
        List<Car> carList = carDao.findAllBetweenDates(from, to);
        carList.forEach(System.out::println);
        model.addAttribute("findCarList", carList);
        return "findCars";
    }
    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car car){
        System.out.println(car);
        carDao.saveCar(car);
        return "redirect:/car/cars";
    }
}
