package com.pouzikov.myPackage.InterviewAglorithms.DynamicProgramming.Practice;

import java.util.*;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequenceNumbers {
//Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//Example:
//Input: [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//
//Note:
//There may be more than one LIS combination, it is only necessary for you to return the length.
//Your algorithm should run in O(n2) complexity.
//
//Follow up: Could you improve it to O(n log n) time complexity?

    public static void main(String[] args) {
        int[] array = {10,9,2,5,3,7,101,18};
        System.out.println(practice(array));

    }
    public static int practice(int[] nums) {
        return 3;

    }


    

    public int lengthOfLIS2(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int maxAnswer = 1;
    for (int i = 1; i < dp.length; i++) {
        int maxValue = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                maxValue = Math.max(maxValue, dp[j]);
            }
        }
        dp[i] = maxValue + 1;
        maxAnswer = Math.max(maxAnswer, dp[i]);
    }
    return maxAnswer;
}

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


}
