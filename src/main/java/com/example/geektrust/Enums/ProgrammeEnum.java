package com.example.geektrust.Enums;

public enum ProgrammeEnum {
    CERTIFICATION(3000.00,0.02d),
    DEGREE(5000.00,0.03d),
    DIPLOMA(2500.00,0.01d);

    private final double course_fee;
    private final double discount_percent;

    ProgrammeEnum(double course_fee,double discount_percent){
        this.course_fee = course_fee;
        this.discount_percent = discount_percent;
    }

    public double getCourse_fee(){
        return this.course_fee;
    }

    public double getDiscount_percent() {
        return discount_percent;
    }
}
