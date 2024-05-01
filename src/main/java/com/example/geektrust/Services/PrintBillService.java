package com.example.geektrust.Services;

import com.example.geektrust.Constants.CouponAmount;

public class PrintBillService {

    private DiscountService discountService;
    private ProgrammeService programmeService;
    private double enrollment_fee;

    public PrintBillService(DiscountService discountService, ProgrammeService programmeService){
        this.discountService = discountService;
        this.programmeService = programmeService;
        this.enrollment_fee = 0.00;
    }

    public void printBill(){
        System.out.println("SUB_TOTAL "+String.format("%.2f",this.programmeService.getTotal_sum()));
        CouponAmount couponAmount =  this.discountService.applyCoupons(this.programmeService.getTotal_sum(),this.programmeService.getTotal_courses(),this.programmeService.getProgrammeList());
        System.out.println("COUPON_DISCOUNT "+couponAmount.getCoupon().name()+" "+String.format("%.2f",couponAmount.getDiscount()));
        System.out.println("TOTAL_PRO_DISCOUNT "+String.format("%.2f",this.programmeService.getPro_member_discount()));
        System.out.println("PRO_MEMBERSHIP_FEE " + String.format("%.2f",this.programmeService.getMember_cost()));

        double val = couponAmount.getAmount();
        if(couponAmount.getAmount() < 6666.00) {
            this.enrollment_fee = 500.00;
            val += 500.00;
        }
        System.out.println("ENROLLMENT_FEE "+String.format("%.2f",this.enrollment_fee));
        System.out.println("TOTAL "+String.format("%.2f",val));
    }
}
