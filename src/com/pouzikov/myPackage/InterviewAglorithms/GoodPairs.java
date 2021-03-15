package com.pouzikov.myPackage.InterviewAglorithms;
//Given an array of integers nums. A pair (i,j) is called good if nums[i] == nums[j] and i < j. Return the number of good
//pairs.
//Input: nums = [1,2,3,1,1,3];

//Example 1;
//Output: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
//
//Example 2:
//Input: nums = [1,1,1,1]
//Output: 6
//Explanation: Each pair in the array are good.

public class GoodPairs {
    public static void main(String[] args) {
        int[] array = {1,1,2,3,1};
        System.out.println(goodPairsPractice(array));
    }

    public static int goodPairsPractice( int[] array){
        if(array.length == 1){
            return 0;
        }
        int counter=0;

        for(int i = 0; i<array.length-1;i++){
            for(int j = i+1; j<array.length;j++){
                if(array[i]==array[j]){
                    counter++;
                }
            }
        }
        return counter;
    }






    public static int numIdenticalPairs(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int counter=0;
        for(int i = 0; i<nums.length-1;i++){
            for(int j =i+1 ;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    counter++;
                }
            }
        }
        return counter;
    }
}
