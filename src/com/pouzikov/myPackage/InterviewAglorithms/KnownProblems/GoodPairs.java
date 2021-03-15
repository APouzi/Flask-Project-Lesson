package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodPairs {
    public static void main(String[] args) {
        int[] array = {1,2,3,1,1,3};
        System.out.println(goodPairs(array));
    }
    public static int wordPairPrac (int[] array){
        int ans = 0, count[] = new int[101];

        for (int i = 0; i < array.length; i++) {
            ans = ans + count[i]++;
        }
        return ans;
    }




    public static int goodPairs(int[] array){
//        "count[] = new int[101]" is also "int[] count = new int[]"
        int res =0, count[] = new int[101];
//count[] is the frequency array.
//When a number first appears, nothing (zero) gets added to "res" and then it's frequency is incremented by 1.
//If it does appear again, the existing frequency gets added and then incremented.
//res += count[a]++;
//This ensures you only add up to the frequency value of (n-1), i.e. 1+2+3+.....+(n-1)
//(same logic as total_count += n * (n-1) / 2)
        for(int i : array){
          res = res + count[i]++;//0, 0, 0,1
        }
        return res;
    }



}
