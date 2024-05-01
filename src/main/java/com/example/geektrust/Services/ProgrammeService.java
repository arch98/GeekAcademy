package com.example.geektrust.Services;

import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.ProgrammeEnum;

import java.util.*;

import static java.util.Collections.sort;

public class ProgrammeService {

    private double total_sum;
    private  int total_courses;
    private double pro_member_discount;
    private final List<Programme> programmeList;
    private double member_cost;

    public ProgrammeService(){
        this.total_sum = 0.00;
        this.total_courses = 0;
        this.pro_member_discount = 0.00;
        this.programmeList = new ArrayList<>();
        this.member_cost = 0.00;
    }
   public void addProgramme(Programme programme){
        double amt = ProgrammeEnum.valueOf(programme.getProgrammeName()).getCourse_fee();
        double val = (programme.getQuantity() *amt);
       this.total_sum = this.total_sum + val;
       this.total_courses = this.total_courses + programme.getQuantity();
       programme.setAmount(amt);
       this.programmeList.add(programme);
    }

    public void addPromember(){
        this.member_cost = 200.00;
        for(Programme programme:programmeList){
            double amt_discount = (ProgrammeEnum.valueOf(programme.getProgrammeName()).getCourse_fee()*ProgrammeEnum.valueOf(programme.getProgrammeName()).getDiscount_percent());
            double discount = (programme.getQuantity()*(ProgrammeEnum.valueOf(programme.getProgrammeName()).getCourse_fee()*ProgrammeEnum.valueOf(programme.getProgrammeName()).getDiscount_percent()));
            this.pro_member_discount = this.pro_member_discount + discount;
            double amount = programme.getAmount()-amt_discount;
            programme.setAmount(amount);
        }

        this.total_sum = this.total_sum - this.pro_member_discount+this.member_cost;
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

    public double getMember_cost() {
        return member_cost;
    }
}
