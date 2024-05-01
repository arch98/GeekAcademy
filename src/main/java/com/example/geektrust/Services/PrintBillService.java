package com.example.geektrust.Services;

import com.example.geektrust.Constants.CouponAmount;

public class PrintBillService {

    private DiscountService discountService;
    private ProgrammeService programmeService;

    public PrintBillService(DiscountService discountService, ProgrammeService programmeService){
        this.discountService = discountService;
        this.programmeService = programmeService;
    }

    public void printBill(){
        System.out.println("SUB_TOTAL "+String.format("%.2f",this.programmeService.getTotal_sum()));
        CouponAmount couponAmount =  this.discountService.applyCoupons(this.programmeService.getTotal_sum(),this.programmeService.getTotal_courses(),this.programmeService.getProgrammeList());
        if(couponAmount.getDiscount() == 0.0){
            System.out.println("COUPON_DISCOUNT NONE "+String.format("%.2f",couponAmount.getDiscount()));
        }else{
            System.out.println("COUPON_DISCOUNT "+couponAmount.getCoupon().name()+" "+String.format("%.2f",couponAmount.getDiscount()));
        }

        if(this.programmeService.isPro_memeber()){
            System.out.println("TOTAL_PRO_DISCOUNT "+String.format("%.2f",this.programmeService.getPro_member_discount()));
            System.out.println("PRO_MEMBERSHIP_FEE 200.00");
        }else {
            System.out.println("TOTAL_PRO_DISCOUNT 0.00");
            System.out.println("PRO_MEMBERSHIP_FEE 0.00");
        }

        double val = couponAmount.getAmount();
        if(couponAmount.getAmount() < 6666.00) {
            System.out.println("ENROLLMENT_FEE 500.00");
            val += 500.00;
        }else{
            System.out.println("ENROLLMENT_FEE 0.00");
        }
        System.out.println("TOTAL "+String.format("%.2f",val));
    }
}
