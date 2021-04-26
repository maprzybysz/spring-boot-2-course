package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private ToyRepo toyRepo;

    @Autowired
    public Start(ToyRepo toyRepo) {
        this.toyRepo = toyRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        Toy toy1 = new Toy("Teddy", ToyType.TEDDY_BEAR);
        Toy toy2 = new Toy("Doll", ToyType.DOLL);
        toyRepo.save(toy1);
        toyRepo.save(toy2);

        System.out.println(toyRepo.findById("6086d23479750760f8314b4e").get());
//        toyRepo.findAll().forEach(System.out::println);
        toyRepo.delete(toy1);

    }
}
