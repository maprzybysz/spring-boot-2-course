package pl.maprzybysz.springboot2.api;

import org.springframework.web.bind.annotation.*;
import pl.maprzybysz.springboot2.model.Dog;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogApi {

    private List<Dog> dogList;

    public DogApi() {
        this.dogList = new ArrayList<>();
        dogList.add(new Dog("Piesek1", "Rasa1"));
        dogList.add(new Dog("Piesek2", "Rasa2"));
        dogList.add(new Dog("Piesek3", "Rasa3"));
    }

    @GetMapping
    public List<Dog> get(@RequestHeader int amount){
        return dogList.subList(0, amount);
    }
    @PostMapping
    public void add(@RequestBody Dog dog){
        dogList.add(dog);
    }
}
