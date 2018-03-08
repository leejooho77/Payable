package com.payable;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {

    private Map<String, Double> menu = new HashMap<>();

    public Map<String, Double> getMenu() {
        return menu;
    }

    public void addFoodToMenu(String foodName, double foodPrice) {
        this.menu.put(foodName, foodPrice);
    }

    public void showMenu() {
        System.out.println(this.menu.toString());
    }
}
