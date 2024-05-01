package com.example.geektrust.Services;

import com.example.geektrust.Constants.CouponAmount;
import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.Coupon;
import com.example.geektrust.Interface.CouponDiscount;

import java.util.List;

public class B4g1Coupon implements CouponDiscount {


   public CouponAmount couponApplied(double total_sum, int num_courses, List<Programme> programmeList){
       double val = programmeList.get(0).getAmount();
       for(Programme programme:programmeList){
           if(val > programme.getAmount()){
               val = programme.getAmount();
           }
       }
       total_sum -= val;
       return new CouponAmount(Coupon.B4G1,total_sum,val);
    }
}
