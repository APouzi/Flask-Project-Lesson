package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

public class Recursion {
    public static void main(String[] args) {

    }
    public static int loop(int num){
        if(num >= 5){
            return 0;
        }
        return num + loop(num+1);
    }
}
