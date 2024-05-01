package com.example.geektrust.Services;

import com.example.geektrust.Constants.CouponAmount;
import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.Coupon;
import com.example.geektrust.Interface.CouponDiscount;

import java.util.ArrayList;
import java.util.List;

public class DiscountService {
    private List<Coupon> appliedCoupons;
    public DiscountService(){
        this.appliedCoupons = new ArrayList<>();
    }

    public void addCoupon(Coupon coupon){
        this.appliedCoupons.add(coupon);
    }


    public CouponAmount applyCoupons(double total_sum, int num_courses,List<Programme>programmeList){
       // Automatically gets added.

        CouponDiscount couponDiscount = null;
        if(num_courses >= 4){
            couponDiscount = new B4g1Coupon();
        }else if(total_sum >= 10000 && this.appliedCoupons.contains(Coupon.DEAL_G20)){
            couponDiscount = new ExplicitAppliedCoupons(Coupon.DEAL_G20);
        }else if(num_courses >= 2 && this.appliedCoupons.contains(Coupon.DEAL_G5)){
            couponDiscount = new ExplicitAppliedCoupons(Coupon.DEAL_G5);
        }

        if(couponDiscount == null){
            return new CouponAmount(Coupon.NONE,total_sum,0.0);
        }
       return couponDiscount.couponApplied(total_sum,num_courses,programmeList);
    }
}
