package com.payable;

public class SitDown extends Restaurant {

    public SitDown() {
        super.addFoodToMenu("Steak", 12.49);
        super.addFoodToMenu("Rib", 13.99);
        super.addFoodToMenu("Pasta", 11.99);
        super.addFoodToMenu("Drink", 1.99);
        super.generateState("New Mexico", 0.05125);
        super.generateState("Montana", 0);
        super.generateState("Mississippi", 0.07);
        super.generateState("Maine", 0.055);
    }
}
