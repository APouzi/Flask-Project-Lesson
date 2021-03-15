package com.pouzikov.myPackage.InterviewAglorithms;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
public class TwoSum {
    public static void main(String[] args) {
        int[] array = {1,2,7,5,9};
       printArray(TwoSumPrac(array,11));
    }


    public static int[] TwoSumPrac(int[] nums, int target){
        return nums;
    }






    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void twoSumFaster (int[] array, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                result[1] = i;
                result[0] = map.get(target - array[i]);
                printArray(result); //return
            }
            map.put(array[i], i);
        }
        printArray(result); // return result
    }
    public static void printArray(int[] array){
        for(int i = 0; i<array.length;i++){
            if(i == array.length-1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + " ");
        }
    }
}
