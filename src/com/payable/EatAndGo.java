package com.payable;

public class EatAndGo extends Restaurant {

    public EatAndGo() {
        super.addFoodToMenu("Cheeseburger", 0.99);
        super.addFoodToMenu("Chicken Sandwich", 3.99);
        super.addFoodToMenu("Chicken Nugget", 4.99);
        super.addFoodToMenu("Fries", 0.99);
        super.addFoodToMenu("Drink", 1.99);
    }
}
