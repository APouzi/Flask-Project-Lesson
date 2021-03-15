package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/climbing-stairs/solution/
public class ClimbingStairs {
//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Example 1:
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//Example 2:
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//

//Constraints:
//1 <= n <= 45


// Explanation https:// www.youtube.com/watch?v=uHAToNgAPaM
public static void main(String[] args) {
    System.out.println(climbingStairsPrac(4));
}

    public static int climbingStairsPrac ( int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];//
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }















//This si a dynamic programming problem and essentially all this is,is how many ways we can solve a certain problem and
//essentially we are just solving how many ways we can solve a certain problem into some sort of DS.
//note if there is another "rule" like you can do "3 steps, 2 steps, and 1 step" then just add that to the dp[i], so like:
//"dp[i] = dp[i-1] + dp[i-2] + dp[i-3]"
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];//(2+1)=3, (3+2)=5
        }
        return dp[n];//3
    }
}
