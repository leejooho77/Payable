package com.payable;

public class EatAndGo extends Restaurant {

    public EatAndGo() {
        super.addFoodToMenu("Cheeseburger", 0.99);
        super.addFoodToMenu("Chicken Sandwich", 3.99);
        super.addFoodToMenu("Chicken Nugget", 4.99);
        super.addFoodToMenu("Fries", 0.99);
        super.addFoodToMenu("Drink", 1.99);
        super.addFoodToMenu("Combo 1: Cheeseburger, Fries, Drink", 2.97);
        super.addFoodToMenu("Combo 2: Chicken Sandwich, Fries, Drink", 4.97);
        super.addFoodToMenu("Combo 3: Chicken Nugget, Fries, Drink", 5.97);
    }
}
