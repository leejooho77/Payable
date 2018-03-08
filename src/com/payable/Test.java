package com.payable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    private static ArrayList<String> order = new ArrayList<>();
    private static Map<Double, Integer> order_amount = new HashMap<>();

    public static void welcomeMessage() {
        System.out.println("Welcome! Choose the restaurant:\n" +
                "1) Sitdown\n" +
                "2) Eat-and-go\n" +
                "Enter the number: ");
    }

    public static void orderFood(String food, double price, int quantity) {
        order.add(food);
        order_amount.put(price, quantity);
        System.out.println(order.toString() + " " + order_amount.toString());
    }

    public static void main(String[] args) {
        Scanner customerInput = new Scanner(System.in);
        Restaurant restaurant;
        int customerNum;

        welcomeMessage();
        customerNum = customerInput.nextInt();
        customerInput.nextLine();

        switch(customerNum) {
            case 1:
                restaurant = new SitDown();
                Waiter waiter = new Waiter();
                restaurant.showMenu();
                waiter.receiveOrder(customerInput, order_amount, restaurant);
                break;
            case 2:
                restaurant = new EatAndGo();
                Cashier cashier = new Cashier();
                restaurant.showMenu();
                cashier.receiveOrder(customerInput, order_amount, restaurant);
                break;
            default:
                System.out.println("[ERROR]: Invalid input");
        }

    }
}
