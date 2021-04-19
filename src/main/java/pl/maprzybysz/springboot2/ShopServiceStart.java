package pl.maprzybysz.springboot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("Start")
public class ShopServiceStart implements ShopService{

    Logger logger = LoggerFactory.getLogger(ShopServiceStart.class);

    @Override
    public void printShoppingCart(List<Product> productList) {
        productList.forEach(System.out::println);
        logger.info("Note: price does not include tax and discount!");
        logger.info("Price: "+calculateTotalPrice(productList));
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
