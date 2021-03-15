package com.pouzikov.myPackage.InterviewAglorithms.Array.Practice;
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//Example:
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//
//Follow up:
//If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
public class MaximumSubarray {
    public static void main(String[] args) {

    }

//max subarray by sum (Nick white) https://www.youtube.com/watch?v=jnoVtCKECmQ
    public static int maxSubArrayNickWhite(int[] array){
        int maxSum = array[0];
        int currentSum = maxSum;

        for(int i = 0; i<array.length;i++){
//Whats greator, adding the number on to the current sum, or starting a new element?
            currentSum = Math.max(currentSum+array[i],array[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }


    public static int maxSubArray(int[] nums) {
        int currMax=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            currMax=Math.max(currMax+nums[i],nums[i]);
            max=Math.max(max,currMax);
        }
        return max;
    }


//Some Div and Con. solution https://leetcode.com/problems/maximum-subarray/discuss/20225/My-Divide-and-Conquer-Solution-in-Java-under-instruction-of-CLRS(O(nlogn))
}
