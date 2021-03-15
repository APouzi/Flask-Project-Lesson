package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

public class WaterBottles {
    public static void main(String[] args) {
        System.out.println(waterBottles2(9,3));//13
    }

    public static int waterBottles2(int bottles, int exchange){
            return 3;
            }









    public static int waterBottles(int bottles, int exchange){
        int counter = 1;
        while(counter <= bottles){
            if(counter%exchange==0){
                bottles++;
            }
            counter++;
        }
        return bottles;
    }
}
