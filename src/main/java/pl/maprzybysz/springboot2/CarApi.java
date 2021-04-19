package pl.maprzybysz.springboot2;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/cars")
public class CarApi {
    private List<Car> cars;

    public CarApi(){
        cars=new ArrayList<>();
        cars.add(new Car(1L, "BMW", "M3", "BLACK"));
        cars.add(new Car(2L, "AUDI", "RS3", "GREEN"));
        cars.add(new Car(3L, "BMW", "M2", "BLACK"));
        cars.add(new Car(4L, "AUDI", "RS4", "GREEN"));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Car>> getCars(){
        return new ResponseEntity(cars, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Optional<Car> findCar = cars.stream().filter(car -> car.getId() == id).findFirst();
        if(findCar.isPresent()){
            return new ResponseEntity<>(findCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("color/{color}")
    public ResponseEntity<List<Car>> getCarsByColor(@PathVariable String color){
       List<Car> findCars = cars.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
       if(findCars.size()>0){
           return new ResponseEntity<>(findCars, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity addCar(@RequestBody Car car){
        boolean add = cars.add(car);
        if(add){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping
    public ResponseEntity modifyCar(@RequestBody Car modifyCar){
        Optional<Car> findCar = cars.stream().filter(car -> car.getId() == modifyCar.getId()).findFirst();
        if(findCar.isPresent()){
            cars.remove(findCar.get());
            cars.add(modifyCar);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PatchMapping("{id}/{param}/{newValue}")
    public ResponseEntity modifyCarParams(@PathVariable Long id, @PathVariable String param,
                                          @PathVariable String newValue){
        Optional<Car> findCar = cars.stream().filter(car -> car.getId() == id).findFirst();
        if(findCar.isPresent()){
            switch (param){
                case "mark":
                    findCar.get().setMark(newValue);
                    break;
                case "model":
                    findCar.get().setModel(newValue);
                    break;
                case "color":
                    findCar.get().setColor(newValue);
                    break;
                default:
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id){
        Optional<Car> findCar = cars.stream().filter(car -> car.getId() == id).findFirst();
        if(findCar.isPresent()){
            cars.remove(findCar.get());
            return new ResponseEntity<>(findCar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
