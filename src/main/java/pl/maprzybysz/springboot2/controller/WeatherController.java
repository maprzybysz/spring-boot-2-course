package pl.maprzybysz.springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maprzybysz.springboot2.client.WeatherClient;
import pl.maprzybysz.springboot2.model.Weather;

@Controller
public class WeatherController {

    private WeatherClient weatherClient;

    @Autowired
    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }
    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/city")
    public String getWeatherByCity(@RequestParam String city, Model model){
        Weather weather = weatherClient.getWeather(city);
        model.addAttribute("weather", weather);
        return "weather";
    }
}
