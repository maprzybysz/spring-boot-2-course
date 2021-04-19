package pl.maprzybysz.springboot2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestAPI {

    @GetMapping
    public ResponseEntity<String> get(){
        return new ResponseEntity("Hello world!", HttpStatus.CONFLICT);
    }
}
