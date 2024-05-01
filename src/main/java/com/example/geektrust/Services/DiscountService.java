package com.example.geektrust.Services;

import com.example.geektrust.Constants.CouponAmount;
import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.Coupon;

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
        if(num_courses >= 4){
            double val = programmeList.get(0).getAmount();
            for(Programme programme:programmeList){
                if(val > programme.getAmount()){
                    val = programme.getAmount();
                }
            }
            total_sum -= val;
            return new CouponAmount(Coupon.B4G1,total_sum,val);
        }

        if(total_sum >= 10000 && this.appliedCoupons.contains(Coupon.DEAL_G20)){
            double discount = total_sum*(0.2d);
            total_sum -= discount;
            return new CouponAmount(Coupon.DEAL_G20,total_sum,discount);
        }

        if(num_courses >= 2 && this.appliedCoupons.contains(Coupon.DEAL_G5)){
            double discount = total_sum*(0.05d);
            total_sum -= discount;
            return new CouponAmount(Coupon.DEAL_G5,total_sum,discount);
        }
        return new CouponAmount(null,total_sum,0.0);
    }
}
