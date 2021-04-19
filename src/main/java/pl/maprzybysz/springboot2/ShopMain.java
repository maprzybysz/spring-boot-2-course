package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopMain {

    private List<Product> productList;
    private ShopService shopService;

    @Autowired
    public ShopMain(ShopService shopService) {
        this.shopService = shopService;
        Product product1 = new Product("Słuchawki", getRandomNumber(50, 300));
        Product product2 = new Product("Myszka", getRandomNumber(50, 300));
        Product product3 = new Product("Klawiatura", getRandomNumber(50, 300));
        Product product4 = new Product("Drukarka", getRandomNumber(50, 300));
        Product product5 = new Product("Dysk", getRandomNumber(50, 300));
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void shop(){
        shopService.printShoppingCart(productList);
    }


    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
