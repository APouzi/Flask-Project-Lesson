package com.pouzikov.myPackage.InterviewAglorithms;

public class MissingNumber {
    public static void main(String[] args) {
       int[] arr = {1,0,3};
        System.out.println(misNum(arr));
    }

    public static int misNum(int[] arr){
        int l = arr.length+1;
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return l*(l-1)/2-sum;
    }
}
