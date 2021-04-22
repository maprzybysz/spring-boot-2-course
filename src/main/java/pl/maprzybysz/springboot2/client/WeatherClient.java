package pl.maprzybysz.springboot2.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.maprzybysz.springboot2.model.Weather;

@Component
public class WeatherClient {

    private static final String API_KEY = "1ddf9ca9b1daa250b4b326db0ac4fcbd";


    public WeatherClient() {}

    public Weather getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject("http://api.weatherstack.com/current?" +
                        "access_key="+API_KEY+
                        "&query="+city,
                Weather.class);

        return weather;
    }

}
