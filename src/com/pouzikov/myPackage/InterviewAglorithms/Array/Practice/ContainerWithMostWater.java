package com.pouzikov.myPackage.InterviewAglorithms.Array.Practice;
public class ContainerWithMostWater {
//Leetcode solution: https://leetcode.com/problems/container-with-most-water/solution/
//Video explanation: https://www.youtube.com/watch?v=TI3e-17YAlc
    public class leetCodeSolution {
        public int maxArea(int[] height) {
            int maxarea = 0, l = 0, r = height.length - 1;
            while (l < r) {
                maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r])
                    l++;
                else
                    r--;
            }
            return maxarea;
        }
    }
}
