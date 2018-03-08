package com.payable;

import java.util.*;

public class Restaurant {

    private Map<String, Double> menu = new LinkedHashMap<>();
    private Map<String, Double> stateTax = new HashMap<>();

    public Map<String, Double> getMenu() {
        return menu;
    }

    public void addFoodToMenu(String foodName, double foodPrice) {
        this.menu.put(foodName, foodPrice);
    }

    public void generateState(String state, double tax) {
        this.stateTax.put(state, tax);
    }

    public void showStates() {
        Iterator<Map.Entry<String, Double>> state_iter = stateTax.entrySet().iterator();
        while(state_iter.hasNext()) {
            Map.Entry<String, Double> state_entry = state_iter.next();
            System.out.println(state_entry.getKey());
        }
        System.out.println();
    }

    public String getState(Scanner input) {
        showStates();
        System.out.print("Enter your state: ");
        return input.nextLine();
    }

    public void showMenu() {
        System.out.println(this.menu.toString());
    }
}
