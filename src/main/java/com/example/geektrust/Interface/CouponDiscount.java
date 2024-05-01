package com.example.geektrust.Interface;

import com.example.geektrust.Constants.CouponAmount;
import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.Coupon;

import java.util.List;

public interface CouponDiscount {

    CouponAmount couponApplied(double total_sum, int num_courses, List<Programme> programmeList);
}
