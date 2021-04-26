package pl.maprzybysz.springboot2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maprzybysz.springboot2.annotation.CounterAnnotation;
import pl.maprzybysz.springboot2.model.Person;
import pl.maprzybysz.springboot2.repository.PersonRepo;


import java.util.List;

@Service
public class PersonService {

    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @CounterAnnotation
    public void savePersonsToDatabase(List<Person> persons) {
        personRepo.deleteAll();
        personRepo.saveAll(persons);
    }


}
