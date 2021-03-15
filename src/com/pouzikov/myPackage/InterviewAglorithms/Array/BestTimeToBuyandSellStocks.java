package com.pouzikov.myPackage.InterviewAglorithms.Array;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Also: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-%3A)-(In-case-if-interviewer-twists-the-input)
public class BestTimeToBuyandSellStocks {
//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design
//an algorithm to find the maximum profit.
//Note: that you cannot sell a stock before you buy one.
//
//Example 1:
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying price.
//
//Example 2:
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
//Faster than 96%
        int ans=0;
        if(prices.length==0)
        {
            return ans;
        }
        int bought=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>bought)
            {
                if(ans<(prices[i]-bought))
                {
                    ans=prices[i]-bought;
                }
            }
            else
            {
                bought=prices[i];
            }
        }
        return ans;
    }

    public class leetCodeSolution {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }
}
