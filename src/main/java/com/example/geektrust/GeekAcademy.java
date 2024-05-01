package com.example.geektrust;

import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.Coupon;
import com.example.geektrust.Services.DiscountService;
import com.example.geektrust.Services.PrintBillService;
import com.example.geektrust.Services.ProgrammeService;

public class GeekAcademy {

   private ProgrammeService programmeService;
    private DiscountService discountService;
    private PrintBillService printBillService;
    public  GeekAcademy(){
        this.programmeService = new ProgrammeService();
        this.discountService = new DiscountService();
        this.printBillService = new PrintBillService(discountService,programmeService);
    }

    public void run(String[] input){

        switch (input[0]) {
            case "ADD_PROGRAMME":
                String[] programmes = input[1].split(" ", 2);
                Programme programme = new Programme(programmes[0], Integer.parseInt(programmes[1]));
                programmeService.addProgramme(programme);
                break;
            case "APPLY_COUPON":
                discountService.addCoupon(Coupon.valueOf(input[1]));
                break;
            case "ADD_PRO_MEMBERSHIP":
                programmeService.addPromember();
                break;
            case "PRINT_BILL":
                printBillService.printBill();
                break;
            default:
                break;
        }
    }
}
