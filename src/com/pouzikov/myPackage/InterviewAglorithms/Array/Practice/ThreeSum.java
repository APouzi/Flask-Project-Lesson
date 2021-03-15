package com.pouzikov.myPackage.InterviewAglorithms.Array.Practice;
//https://leetcode.com/problems/3sum/
public class ThreeSum {
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets
//in the array which gives the sum of zero.
//
//Note: The solution set must not contain duplicate triplets.
//
//Example:
//Given array nums = [-1, 0, 1, 2, -1, -4],
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]


//Nick White solution: https://www.youtube.com/watch?v=IzHR_U8Ly6c

    public static int findMin(int[] nums){
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int midpoint = left + (right-left)/2;
            if(midpoint > 0 && nums[midpoint] < nums[midpoint-1]){
                return nums[midpoint];
            } else if(nums[left]<= nums[midpoint] && nums[midpoint] > nums[right]){
                left = midpoint +1;
            } else{
                right = midpoint -1;
            }
        }
        return nums[left];
    }
}
