package pl.maprzybysz.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maprzybysz.springboot2.model.Notepad;

@Repository
public interface NotepadRepo extends JpaRepository<Notepad, Long> {
}
