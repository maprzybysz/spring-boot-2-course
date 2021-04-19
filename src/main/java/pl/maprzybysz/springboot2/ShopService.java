package pl.maprzybysz.springboot2;

import java.util.List;

public interface ShopService {
     void printShoppingCart(List<Product> productList);
     double calculateTotalPrice(List<Product> productList);
}
