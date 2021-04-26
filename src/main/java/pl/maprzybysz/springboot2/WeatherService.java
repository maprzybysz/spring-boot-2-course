package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.maprzybysz.springboot2.model.Current;
import pl.maprzybysz.springboot2.model.Weather;
import pl.maprzybysz.springboot2.model.WeatherWrapper;

@Service
public class WeatherService {

    @Value("${API.KEY}")
    private String API_KEY;

    public WeatherWrapper getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject("http://api.weatherstack.com/current?" +
                        "access_key="+API_KEY+
                        "&query="+city,
                Weather.class);

        Current current = weather.getCurrent();
        WeatherWrapper weatherWrapper = new WeatherWrapper(city, current.getObservationTime(), current.getTemperature(),
                current.getWindSpeed(),
                current.getPressure(), current.getHumidity());
        return weatherWrapper;
    }
}
