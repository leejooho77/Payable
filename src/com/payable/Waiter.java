package com.payable;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Waiter implements PayableWithTip {
    @Override
    public double addTip(double originalPrice, double tip) {
        return originalPrice + tip;
    }

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

    public void receiveOrder(Scanner customerInput, Map<Double, Integer> order_amount, Restaurant restaurant) {
        boolean checkout = false;
        int customerNum;
        double customerDou;
        String customerStr;

        while(!checkout) {
            System.out.print("Enter the name of food that you would like to have: ");
            customerStr = customerInput.nextLine();
            double price = restaurant.getMenu().get(customerStr);
            System.out.print("Enter the amount of food: ");
            customerNum = customerInput.nextInt();
            customerInput.nextLine();
            Test.orderFood(customerStr, price, customerNum);
            System.out.print("Do you want to proceed to checkout? (yes/no): ");
            customerStr = customerInput.nextLine();
            if(customerStr.equalsIgnoreCase("yes")) {
                double originalPrice = this.getTotalPrice(order_amount);
                System.out.println("Total price: " + originalPrice);
                System.out.print("Enter the amount of tip: ");
                customerDou = customerInput.nextDouble();
                customerInput.nextLine();
                double priceWithTip = this.addTip(originalPrice, customerDou);
                System.out.println("Final price: " + priceWithTip);
                System.out.print("Enter the amount you want to pay in cash: ");
                customerDou = customerInput.nextDouble();
                customerInput.nextLine();
                System.out.println("The change is " + this.payBill(customerDou, priceWithTip) +
                        ". Bye!");
                checkout = true;
            }
        }
    }
}
