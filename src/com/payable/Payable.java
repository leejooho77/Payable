package com.payable;

import java.util.Map;

public interface Payable {

    public double getTotalPrice(Map<Double, Integer> order);
    public double payBill(double paid, double amount);
}
