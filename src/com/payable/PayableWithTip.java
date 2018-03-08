package com.payable;

public interface PayableWithTip extends Payable {

    public double addTip(double originalPrice, double tip);
}
