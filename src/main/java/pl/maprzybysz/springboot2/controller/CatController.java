package pl.maprzybysz.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.maprzybysz.springboot2.model.AnimalFact;

@Controller
public class CatController {

    public CatController() {

        RestTemplate restTemplate = new RestTemplate();

        AnimalFact[] facts = restTemplate.getForObject("https://cat-fact.herokuapp" +
                        ".com/facts/random?animal_type=cat&amount=3",
                AnimalFact[].class);


        for (AnimalFact animalFact: facts) {
            System.out.println(animalFact);

        }
    }
}
