package com.pouzikov.myPackage.InterviewAglorithms.Array.Practice;

import java.util.HashMap;
import java.util.HashSet;
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
       twoSum(array,11);
    }
    public static void twoSum(int[] array, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> record = new HashMap<>();

        for(int i = 0; i<array.length;i++){
            if(record.containsKey(target-array[i])){
                result[0] = record.get(target-array[i]);
                result[1] = i;
            }
            record.put(array[i],i);
        }
        printArray(result);
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
            System.out.print(array[i]);
        }
    }
}
