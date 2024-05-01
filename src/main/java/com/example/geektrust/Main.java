package com.example.geektrust;

import com.example.geektrust.Constants.Programme;
import com.example.geektrust.Enums.Coupon;
import com.example.geektrust.Enums.ProgrammeEnum;
import com.example.geektrust.Services.DiscountService;
import com.example.geektrust.Services.PrintBillService;
import com.example.geektrust.Services.ProgrammeService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GeekAcademy geekAcademy = new GeekAcademy();

       // Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String[] input = sc.nextLine().split(" ", 2);
                geekAcademy.run(input);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

    }
}
