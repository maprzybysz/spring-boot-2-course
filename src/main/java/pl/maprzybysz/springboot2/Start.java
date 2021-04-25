package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private CarRepo carRepo;

    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        Car car1 = new Car("BMW", "M3", Color.BLACK);
        Car car2 = new Car("BMW", "M2", Color.BLACK);
        Car car3 = new Car("BMW", "M4", Color.RED);
        Car car4 = new Car("AUDI", "RS4", Color.BLACK);

        carRepo.save(car1);
        carRepo.save(car2);
        carRepo.save(car3);
        carRepo.save(car4);

        carRepo.findCarsByColor(Color.BLACK).forEach(System.out::println);
        carRepo.findCarsByColorAndMark(Color.BLACK, "AUDI").forEach(System.out::println);
    }
}
