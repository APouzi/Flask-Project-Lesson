package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/house-robber/

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
//the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
//it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
//money you can rob tonight without alerting the police.
//
//
//
//Example 1:
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//
//Example 2:
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//
//Constraints:
//
//    0 <= nums.length <= 100
//    0 <= nums[i] <= 400

//Nick White: https://www.youtube.com/watch?v=ZwDDLAeeBM0

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println( houseRobbersPrac(nums));
    }



    public static int houseRobbersPrac(int[] nums) {
        return 3;
    }












//Array: 1,2,3,1
//So we can start at whatever indices, but we can't do the next one. How would we solve this? We would have to do this by
//We can use memoization, graph out each one of these.
    public static int houseRobbers(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length +1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
//the dp[i-1] + nums[i], is testing the house robbed that was one back and the current price. and adding them together.
//on the first iteration, dp[0] is 0, and that means when we do dp[1-1]+nums[i], we are saying that its 0+nums[i]. Remember,
// dp[1] is nums[0].
            dp[i+1] =  Math.max(dp[i], dp[i-1] + nums[i]);//dp[i-1] + nums[i]: 0|(0+2), 3|(2+3),
//dp: 0, 1, 2, (1+3), (2+1)
        }
        return dp[nums.length];
    }
}
