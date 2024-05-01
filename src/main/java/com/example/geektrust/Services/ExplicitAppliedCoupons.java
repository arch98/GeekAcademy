package com.example.geektrust.Services;

import com.example.geektrust.Constants.CouponAmount;
import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.Coupon;
import com.example.geektrust.Interface.CouponDiscount;

import java.util.List;

public class ExplicitAppliedCoupons implements CouponDiscount {
    private Coupon coupon;

   public ExplicitAppliedCoupons(Coupon coupon){
       this.coupon = coupon;
   }

    public CouponAmount couponApplied(double total_sum, int num_courses, List<Programme> programmeList){
        double discount = total_sum*(coupon.getPercent());
        total_sum -= discount;
        return new CouponAmount(Coupon.valueOf(coupon.name()),total_sum,discount);
    }
}
