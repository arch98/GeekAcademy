package com.example.geektrust.Enums;

public enum Coupon {
    B4G1(0d),
    DEAL_G20(0.2d),
    DEAL_G5(0.05d),
    NONE(0d);

    private double percent;

    Coupon(double percent){
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}
