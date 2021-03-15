package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//Example 1:
//Input: [3,0,1]
//Output: 2
//
//Example 2:
//
//Input: [9,6,4,2,3,5,7,0,1]
//Output: 8
//Input: [3,2,1,0]
//output: 4
//Input: [3,2,1]
//output: 0

//Note:
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,8,9,0};//7
//        System.out.println(misNumber(nums));
        misNumberPrac(nums);
    }


    public static void misNumberPrac(int[] num){
        int sum = num.length;
        for (int i = 0; i < num.length; i++) {
            sum += i - num[i];
        }
        System.out.println(sum);
    }









    public static int misNumber(int[] array){
        int sum = array.length;//3
        for(int i = 0; i< array.length; i++){
            sum += i - array[i];
        }
        return sum;
    }




    public static int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }




    public static void misNumMyAns(int[] arr) { //NOT RIGHT DUE TO EDGE CASES
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 1; i< arr.length;i++){
            if(arr[i-1]+1 != arr[i]){
                ans= arr[i-1] +1;
            }
        }
        System.out.println(ans);
    }


}
