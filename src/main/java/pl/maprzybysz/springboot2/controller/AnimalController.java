package pl.maprzybysz.springboot2.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.maprzybysz.springboot2.model.AnimalFact;


@Controller
public class AnimalController {


    private AnimalFact getCatFact() {
        RestTemplate restTemplate = new RestTemplate();
        AnimalFact fact = restTemplate.getForObject("https://cat-fact.herokuapp" +
                        ".com/facts/random?animal_type=cat&amount=1",
                AnimalFact.class);
        JsonNode jsonNode = restTemplate.getForObject("https://aws.random.cat/meow", JsonNode.class).get("file");
        fact.setSrc(jsonNode.asText());
        return fact;
    }


    @GetMapping("/animal-fact")
    public String get(Model model){
        model.addAttribute("fact", getCatFact());
        return "animalView";
    }
}
