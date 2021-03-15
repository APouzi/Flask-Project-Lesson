package com.pouzikov.myPackage.InterviewAglorithms.Array;
//https://leetcode.com/problems/product-of-array-except-self/

//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of
//all the elements of nums except nums[i].
//
//Example:
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
//
//Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array)
//fits in a 32 bit integer.
//
//Note: Please solve it without division and in O(n).
//
//Follow up:
//Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
public class ProductofArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

// LeetCode Solution O(n):  https://leetcode.com/problems/product-of-array-except-self/solution/
            public int[] leetCodeSolution(int[] nums) {

                // The length of the input array
                int length = nums.length;

                // Final answer array to be returned
                int[] answer = new int[length];

                // answer[i] contains the product of all the elements to the left
                // Note: for the element at index '0', there are no elements to the left,
                // so the answer[0] would be 1
                answer[0] = 1;
                for (int i = 1; i < length; i++) {

                    // answer[i - 1] already contains the product of elements to the left of 'i - 1'
                    // Simply multiplying it with nums[i - 1] would give the product of all
                    // elements to the left of index 'i'
                    answer[i] = nums[i - 1] * answer[i - 1];
                }

                // R contains the product of all the elements to the right
                // Note: for the element at index 'length - 1', there are no elements to the right,
                // so the R would be 1
                int R = 1;
                for (int i = length - 1; i >= 0; i--) {

                    // For the index 'i', R would contain the
                    // product of all elements to the right. We update R accordingly
                    answer[i] = answer[i] * R;
                    R *= nums[i];
                }

                return answer;
            }
}
