package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.maprzybysz.springboot2.repository.WeatherWrapperRepo;


@Component
public class Main {

    private WeatherService weatherService;
    private WeatherWrapperRepo weatherWrapperRepo;

    @Autowired
    public Main(WeatherService weatherService, WeatherWrapperRepo weatherWrapperRepo) {
        this.weatherService = weatherService;
        this.weatherWrapperRepo = weatherWrapperRepo;
    }


    @Scheduled(cron = "0 0 0/1 1/1 * ?")
    public void init(){
        weatherWrapperRepo.save(weatherService.getWeather("Warszawa"));
    }
}
