package pl.maprzybysz.springboot2;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.maprzybysz.springboot2.model.Person;
import pl.maprzybysz.springboot2.service.PersonService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class Start {

    private PersonService personService;

    @Autowired
    public Start(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> getPersonsFromFile(String fileName) throws FileNotFoundException {
        List<Person> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Person.class)
                .build()
                .parse();
        return beans;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() throws FileNotFoundException {
        personService.savePersonsToDatabase(getPersonsFromFile("data.csv"));

    }

}
