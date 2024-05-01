package com.example.geektrust.Services;

import com.example.geektrust.Constants.Programme;

import java.util.*;

import static java.util.Collections.sort;

public class ProgrammeService {

    private double total_sum;
    private  int total_courses;
    private double pro_member_discount;
    private boolean pro_memeber;
    private List<Programme> programmeList;

    public ProgrammeService(){
        this.total_sum = 0.00;
        this.total_courses = 0;
        this.pro_member_discount = 0.00;
        this.pro_memeber = false;
        this.programmeList = new ArrayList<>();
    }
   public void addProgramme(Programme programme){
        double amt = programme.getProgrammeEnum().getCourse_fee();
        double val = (programme.getQuantity() * programme.getProgrammeEnum().getCourse_fee());
       this.total_sum = this.total_sum + val;
       this.total_courses = this.total_courses + programme.getQuantity();
       programme.setAmount(amt);
       this.programmeList.add(programme);
    }

    public void addPromember(){
        this.pro_memeber = true;
        for(Programme programme:programmeList){
            double amt_discount = (programme.getProgrammeEnum().getCourse_fee()*programme.getProgrammeEnum().getDiscount_percent());
            double discount = (programme.getQuantity()*(programme.getProgrammeEnum().getCourse_fee()*programme.getProgrammeEnum().getDiscount_percent()));
            this.pro_member_discount = this.pro_member_discount + discount;
            double amount = programme.getAmount()-amt_discount;
            programme.setAmount(amount);
        }

        this.total_sum = this.total_sum - this.pro_member_discount+200;
    }

    public double getPro_member_discount() {
        return this.pro_member_discount;
    }

    public int getTotal_courses() {
        return total_courses;
    }

    public double getTotal_sum() {
        return this.total_sum;
    }

    public List<Programme> getProgrammeList() {
        return programmeList;
    }

    public void setTotal_sum(double total_sum){
        this.total_sum = total_sum;
    }

    public boolean isPro_memeber() {
        return pro_memeber;
    }
}
