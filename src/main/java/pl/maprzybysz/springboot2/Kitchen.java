package pl.maprzybysz.springboot2;


import pl.maprzybysz.springboot2.meal.FoodType;
import pl.maprzybysz.springboot2.meal.KitchenMeal;

public abstract class Kitchen {
    public abstract KitchenMeal getMeal(FoodType preferency);

    public abstract KitchenMeal getDessert(FoodType preferency);
}