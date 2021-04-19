package pl.maprzybysz.springboot2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductAPI {

    @GetMapping//("/products")
    public String getProducts(){
        return "Hello World with GET";
    }
    @PostMapping//("/products")
    public String addProduct(){
        return "Hello World with POST";
    }
    @PutMapping//("/products")
    public String modifyProduct(){
        return "Hello World with PUT";
    }
    @DeleteMapping//("/products")
    public String deleteProduct(){
        return "Hello World with DELETE";
    }
}
