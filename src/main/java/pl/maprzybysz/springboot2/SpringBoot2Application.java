package pl.maprzybysz.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Application.class, args);
    }



}
