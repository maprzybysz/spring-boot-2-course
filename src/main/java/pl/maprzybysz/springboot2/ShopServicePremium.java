package pl.maprzybysz.springboot2;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("Premium")
public class ShopServicePremium extends ShopServicePlus{

    @Value("${shop.discount}")
    private double discount;

    @Override
    public void printShoppingCart(List<Product> productList) {
        double totalPrice = calculateTotalPrice(productList);
        double amountTax = calculateTax(totalPrice);
        double amountDiscount = calculateDiscount(totalPrice+amountTax);
        productList.forEach(System.out::println);
        System.out.println("Price: "+ totalPrice + " tax: "+amountTax + " discount: " + amountDiscount);
        System.out.println("Total price: " + (totalPrice+amountTax-amountDiscount));
    }

    public double calculateDiscount(double price){
        return Math.round(price*discount);
    }


}
