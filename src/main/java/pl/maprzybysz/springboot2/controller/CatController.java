package pl.maprzybysz.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatController {

    public CatController() {

        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject("https://cat-fact.herokuapp" +
                        ".com/facts/random?animal_type=cat&amount=1",
                String.class);

        System.out.println(forObject);

    }
}
