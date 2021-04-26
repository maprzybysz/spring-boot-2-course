package pl.maprzybysz.springboot2.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.maprzybysz.springboot2.model.Person;

@Repository
public interface PersonRepo extends MongoRepository<Person, String> {


}
