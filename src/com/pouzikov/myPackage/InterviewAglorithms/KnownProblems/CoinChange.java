package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
//You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest
//number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of
//the coins, return -1.
//
//Example 1:
//Input: coins = [1, 2, 5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//
//Example 2:
//Input: coins = [2], amount = 3
//Output: -1
//
//Note:
//You may assume that you have an infinite number of each kind of coin.

// Explanation: https://www.youtube.com/watch?v=1R0_7HqNaW0


    public static void main(String[] args) {
        CoinChange rh = new CoinChange();
        int[] coins = {1, 10};//7
        System.out.println(coinChange2(coins, 25));
    }

    public static int coinChange2(int[] coins, int amount) {
        return 3;
        }



















    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
//Here we fill out entire array with the entire DP amount +1 because we want an invalid amount of coins.
        Arrays.fill(dp, amount);
//zero coins need zero coins to fill zero coins so we have this.
        dp[0] = 0;
//
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }else{
//because we sorted the coins, we don't have to go through every coin to make sure that we have the best coin.
                    break;
                }
            }
        }
//    return dp[amount] > amount ? -1 : dp[amount];
        if (dp[amount] > amount) {
            return -1;
        } else {
            System.out.println(dp[amount]);
            return dp[amount];
        }
    }


}
