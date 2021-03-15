package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        printArray(twoSumPrac(array,11));

    }

    public static int[] twoSumPrac(int[] array, int target){
        return array;
    }








    public static int[] twoSum(int[] array, int target) {
        int[] dp = new int[2];
        Map<Integer,Integer> record = new HashMap<>();
        dp[0]=1;
        for(int i = 0; i<array.length;i++){
            if(record.containsKey(target-array[i])){
                dp[0] = record.put(target-array[i],i);
                dp[1] = i;
            }
            record.put(array[i],i);
        }
        return dp;
    }

    public static int[] twoSum3 (int[] array, int target){
        int[] dp = new int[2];
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[i]+ array[j] == target) {
                    dp[0] = array[i];
                    dp[1] = array[j];
                }
            }
        }
        return dp;
    }









    public static void twoSumFaster (int[] array, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                result[1] = i;
                result[0] = map.get(target - array[i]);
            }
            map.put(array[i], i);
        }
        printArray(result); // return result
    }
    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + ",");
        }
    }
}
