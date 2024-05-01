package com.example.geektrust.Constants;

import com.example.geektrust.Enums.ProgrammeEnum;

import java.util.Comparator;

public class Programme{

    private final String programmeName;
    private final int quantity;
    private double amount;

    public Programme(String programmeEnum, int quantity){
        this.programmeName = programmeEnum;
        this.quantity =quantity;
        this.amount = 0.0;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
