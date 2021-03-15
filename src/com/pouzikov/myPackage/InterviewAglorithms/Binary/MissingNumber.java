package com.pouzikov.myPackage.InterviewAglorithms.Binary;
//https://leetcode.com/problems/missing-number/

public class MissingNumber {
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//Example 1:
//Input: [3,0,1]
//Output: 2
//
//Example 2:
//Input: [9,6,4,2,3,5,7,0,1]
//Output: 8
//
//Note:
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

//Kevin Naughton Jr: https://www.youtube.com/watch?v=YMYVYSWL93w

    public static void main(String[] args) {
        int[] answer = {1,0,3};
        missingNumber(answer);
    }
    public static int missingNumber(int[] array){
        int sum = 0;

        for(int i : array){
            sum += i;
        }

        int n = array.length+1;
        int answer =  (n *  (n-1)/2) - sum;
        System.out.println(answer);
        return answer;
    }

}
