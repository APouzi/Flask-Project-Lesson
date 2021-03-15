package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/maximum-product-subarray/

import java.util.*;

//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//Example 1:
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
//
//Example 2:
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] array = {2,3,-2,4};
        System.out.println(maxProd2(array));
    }

public static int maxProd2(int[] array){
return 3;
}






    public static int maxProd(int[] array){
        int answer =0, current = 0;

        for (int i = 0; i < array.length; i++) {
            current = Math.max(current*array[i],array[i]);
            answer = Math.max(answer,current);
        }
        return answer;
    }





    public int maxProduct(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int max = A[0];
        int min = A[0];
        int totalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            int tempMax = A[i] * max;
            int tempMin = A[i] * min;
            max = Math.max(Math.max(tempMax,tempMin), A[i]);
            min = Math.min(Math.min(tempMax,tempMin), A[i]);
            totalMax = Math.max(totalMax, max);
        }
        return totalMax;
    }


}
