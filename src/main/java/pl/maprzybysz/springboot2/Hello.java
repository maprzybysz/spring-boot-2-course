package pl.maprzybysz.springboot2;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Hello {

    //@Scheduled(fixedDelay = 1000)
    @Schedules({
            @Scheduled(fixedDelay = 1),
            @Scheduled(cron = "0 0 12 * * ?")
    })
    public void get(){
        System.out.println(LocalTime.now());
    }
}
