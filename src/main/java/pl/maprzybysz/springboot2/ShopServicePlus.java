package pl.maprzybysz.springboot2;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("Plus")
public class ShopServicePlus extends ShopServiceStart{

    @Value("${shop.tax}")
    private double tax;

    @Override
    public void printShoppingCart(List<Product> productList) {
        double totalPrice = calculateTotalPrice(productList);
        double amountTax = calculateTax(totalPrice);
        productList.forEach(System.out::println);
        System.out.println("Note: price does not include discount!");
        System.out.println("Price: "+ totalPrice + " tax: "+amountTax);
        System.out.println("Total price: " + (totalPrice+amountTax));
    }

    public double calculateTax(double price){
        return Math.round(price * tax);
    }
}
