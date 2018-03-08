package com.payable;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Cashier implements Payable {
    @Override
    public double getTotalPrice(Map<Double, Integer> order) {
        double total_price = 0;
        Iterator<Map.Entry<Double, Integer>> order_iter = order.entrySet().iterator();
        while(order_iter.hasNext()) {
            Map.Entry<Double, Integer> order_entry = order_iter.next();
            total_price += order_entry.getValue() * order_entry.getKey();
        }
        return total_price;
    }

    @Override
    public double payBill(double paid, double amount) {
        return paid - amount;
    }

    @Override
    public double getTax(Map<String, Double> taxChart, String state) {
        return 0;
    }

    public void receiveOrder(Scanner customerInput, Map<Double, Integer> order_amount, Restaurant restaurant) {
        boolean checkout = false;
        int customerNum;
        double customerDou;
        double price;
        String customerStr;

        while(!checkout) {
            System.out.println("Would you like to order a combo? (yes/no)");
            customerStr = customerInput.nextLine();
            if(customerStr.equals("yes")){
                System.out.println("Enter the combo number: ");
                customerNum = customerInput.nextInt();
                customerInput.nextLine();
                switch (customerNum) {
                    case 1:
                        price = restaurant.getMenu().get("Combo 1: Cheeseburger, Fries, Drink");
                        Test.orderFood("Combo 1: Cheeseburger, Fries, Drink", price, 1);
                        break;
                    case 2:
                        price = restaurant.getMenu().get("Combo 2: Chicken Sandwich, Fries, Drink");
                        Test.orderFood("Combo 2: Chicken Sandwich, Fries, Drink", price, 1);
                        break;
                    case 3:
                        price = restaurant.getMenu().get("Combo 3: Chicken Nugget, Fries, Drink");
                        Test.orderFood("Combo 3: Chicken Nugget, Fries, Drink", price, 1);
                        break;
                    default:
                        System.out.println("Invalid combo");
                }
            } else {
                System.out.print("Enter the name of food that you would like to have: ");
                customerStr = customerInput.nextLine();
                price = restaurant.getMenu().get(customerStr);
                System.out.print("Enter the amount of food: ");
                customerNum = customerInput.nextInt();
                customerInput.nextLine();
                Test.orderFood(customerStr, price, customerNum);
            }
            System.out.print("Do you want to proceed to checkout? (yes/no): ");
            customerStr = customerInput.nextLine();
            if(customerStr.equalsIgnoreCase("yes")) {
                double originalPrice = this.getTotalPrice(order_amount);
                System.out.println("Total price: " + originalPrice);
                System.out.print("Enter the amount you want to pay in cash: ");
                customerDou = customerInput.nextDouble();
                customerInput.nextLine();
                System.out.format("The change is %.2f\nBye!", this.payBill(customerDou, originalPrice));
                checkout = true;
            }
        }
    }
}
