package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/unique-paths/

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). The robot can only
//move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid
//(marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
//
//
//Above is a 7 x 3 grid. How many possible unique paths are there?
//

//Example 1:
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
//
//Example 2:
//Input: m = 7, n = 3
//Output: 28
//

//Constraints:
//1 <= m, n <= 100
//It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.

//Kevin Naughton Jr. https://www.youtube.com/watch?v=6qMFjFC9YSc
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePathsPrac(3,2));
    }

    public static int uniquePathsPrac(int row, int col){
        return 3;
    }














//https://leetcode.com/problems/unique-paths/discuss/184248/8-lines-Java-DP-solution-0ms-beats-100-explained-with-graph
//The idea is to use a 2D array to keep track of the total possible ways to enter specific block.
//Since we can only go "DOWN" and "RIGHT", therefore each block could be entered from both "ABOVE" and "LEFT", therefore
//adding up their total ways would give the total ways for current block.
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];
//In order to save the hassles in the future initialize "dp[1][0]"
        dp[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];//dp[0][1]+dp[1][0], dp[0][2]+dp[1][1], dp[1][2]+dp[2][1]
            }                                          //dp[1][1]+dp[2][0],dp[1][2]+d[2][1],dp[1][3]+dp[2][2]
        }
        return dp[n][m];
    }
}
// 0,0,0,0
// 1,1,1,1 
// 0,1,2,3