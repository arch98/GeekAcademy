package com.example.geektrust.Constants;

import com.example.geektrust.Enums.ProgrammeEnum;

import java.util.Comparator;

public class Programme{

    private final ProgrammeEnum programmeEnum;
    private final int quantity;

    private double amount;

    public Programme(ProgrammeEnum programmeEnum, int quantity){
        this.programmeEnum = programmeEnum;
        this.quantity =quantity;
        this.amount = 0.0;
    }

    public ProgrammeEnum getProgrammeEnum() {
        return programmeEnum;
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
