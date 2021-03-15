package com.pouzikov.myPackage.InterviewAglorithms.Array;
//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
//Leetcode solution: https://leetcode.com/problems/container-with-most-water/solution/
//    Note: look at image on site.
//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
//are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
//forms a container, such that the container contains the most water.
//
//Note: You may not slant the container and n is at least 2.
//
//The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section)
//the container can contain is 49.
//
//
//
//Example:
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49

//Video explanation: https://www.youtube.com/watch?v=TI3e-17YAlc

    public static void main(String[] args) {

    }
//In a sense this line is asking us which two boundries in the given array, can contain the most water.
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

