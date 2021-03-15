package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

import java.util.Scanner;

public class ExactChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int input = scanner.nextInt();
        scanner.close();

        exactChange(input);
    }

    public static void exactChange(int input){

        int dollars = input/100;
        input %= 100;

        int Quarters = input/25;
        input %= 25;

        int dimes = input/10;
        input %=10;

        int nickels = input/5;
        input %= 5;

        int pennies = input/1;
        input %= 1;

        System.out.println("Dollars: " + dollars + "\nQuarters: " + Quarters + "\ndimes: " + dimes + "\nnickels: " + nickels + "\nPennies: " +pennies);
    }
}
