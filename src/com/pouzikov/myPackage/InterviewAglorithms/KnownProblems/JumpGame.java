package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/jump-game/

//Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in
//the array represents your maximum jump length at that position. Determine if you are able to reach the last index.
//

//Example 1:
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//Example 2:
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible
//to reach the last index.
//
//Constraints:
//1 <= nums.length <= 3 * 10^4
//0 <= nums[i][j] <= 10^5

// Nick White: https://www.youtube.com/watch?v=Zb4eRjuPHbM
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] numsF = {3,2,1,0,4};
        System.out.println(jumpGameP(nums));
    }

    public static boolean jumpGameP(int[] nums){
        int lastIndex = nums.length;

        for(int i = nums.length-1; i >= 0; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }








//Array: 2,3,1,1,4
    public static boolean jumpGame(int[] nums){
        int lastGoodIndex = nums.length-1;
        for (int i = nums.length-1; i >= 0; i--) {
            if(i + nums[i] >= lastGoodIndex){
                lastGoodIndex = i;
            }
        }
        return (lastGoodIndex == 0);
    }
//if:(4+4),(3+1),(2+1),(1+3),(0+2)
//lastGoodIndex: true, true, true, true, true
}
