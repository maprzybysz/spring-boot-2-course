package pl.maprzybysz.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maprzybysz.springboot2.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
