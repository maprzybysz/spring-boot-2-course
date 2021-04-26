package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maprzybysz.springboot2.model.Backpack;
import pl.maprzybysz.springboot2.model.Notepad;
import pl.maprzybysz.springboot2.model.Professor;
import pl.maprzybysz.springboot2.model.Student;
import pl.maprzybysz.springboot2.repository.BackpackRepo;
import pl.maprzybysz.springboot2.repository.NotepadRepo;
import pl.maprzybysz.springboot2.repository.ProfessorRepo;
import pl.maprzybysz.springboot2.repository.StudentRepo;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Main {

    private StudentRepo studentRepo;
    private BackpackRepo backpackRepo;
    private NotepadRepo notepadRepo;
    private ProfessorRepo professorRepo;

    @Autowired
    public Main(StudentRepo studentRepo, BackpackRepo backpackRepo, NotepadRepo notepadRepo, ProfessorRepo professorRepo) {
        this.studentRepo = studentRepo;
        this.backpackRepo = backpackRepo;
        this.notepadRepo = notepadRepo;
        this.professorRepo = professorRepo;


        Backpack backpack1 = new Backpack("Backpack1");
        backpackRepo.save(backpack1);
        Backpack backpack2 = new Backpack("Backpack");
        backpackRepo.save(backpack2);

        Notepad notepad1 = new Notepad("SQL");
        notepad1.setBackpack(backpack1);
        notepadRepo.save(notepad1);
        Notepad notepad2 = new Notepad("SPRING");
        notepad2.setBackpack(backpack2);
        notepadRepo.save(notepad2);


        Student student1 = new Student("Karol", "Kowalski", "A2");
        student1.setBackpack(backpack1);
        Student student2 = new Student("Jacek", "Placek", "A2");
        student2.setBackpack(backpack2);
        Set<Student> studentSet = Stream.of(student1, student2).collect(Collectors.toSet());

        Professor professor1 = new Professor("Piotr", "Karwo", "Ph.D.");
        Professor professor2 = new Professor("Waldemar", "Wrzecio", "Ph.D.");
        Set<Professor> professorSet = Stream.of(professor1, professor2).collect(Collectors.toSet());

        professor1.setStudentSet(studentSet);
        professor2.setStudentSet(studentSet);

        student1.setProfessorSet(professorSet);
        student2.setProfessorSet(professorSet);

        studentRepo.save(student1);
        studentRepo.save(student2);
        professorRepo.save(professor1);
        professorRepo.save(professor2);
    }


}
