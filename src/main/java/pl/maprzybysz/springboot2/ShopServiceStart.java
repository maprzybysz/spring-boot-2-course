package pl.maprzybysz.springboot2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("Start")
public class ShopServiceStart implements ShopService{

    @Override
    public void printShoppingCart(List<Product> productList) {
        productList.forEach(System.out::println);
        System.out.println("Note: price does not include tax and discount!");
        System.out.println("Price: "+calculateTotalPrice(productList));
    }

    @Override
    public double calculateTotalPrice(List<Product> productList) {
        double price = 0;
        for (Product product:productList){
            price += product.getPrice();
        }
        return price;
    }
}
