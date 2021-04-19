package pl.maprzybysz.springboot2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductAPI {


        //Parameter /products?name="name"&surname="surname"
//    @GetMapping
//    public String getProducts(@RequestParam String name,
//                              @RequestParam(required = false, defaultValue = "Kowalski") String surname){
//        return "Hello "+name+" "+surname;
//    }
        //Path /products/name
//    @GetMapping("/{name}")
//    public String getProducts(@PathVariable String name){
//        return "Hello "+name;
//    }
    //Header
//    @GetMapping
//    public String getProducts(@RequestHeader String name){
//        return "Hello "+name;
//    }

    //Body
    @GetMapping
    public String getProducts(@RequestBody String name){
        return "Hello "+name;
    }

    @PostMapping
    public String addProduct(){
        return "Hello World with POST";
    }
    @PutMapping
    public String modifyProduct(){
        return "Hello World with PUT";
    }
    @DeleteMapping
    public String deleteProduct(){
        return "Hello World with DELETE";
    }
}
