package com.example.geektrust.Constants;

import com.example.geektrust.Enums.Coupon;

public class CouponAmount {

    private final Coupon coupon;
    private final double amount;
    private final double discount;

    public CouponAmount(Coupon coupon,double amount,double discount){
        this.coupon = coupon;
        this.amount = amount;
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public double getDiscount() {
        return discount;
    }
}
