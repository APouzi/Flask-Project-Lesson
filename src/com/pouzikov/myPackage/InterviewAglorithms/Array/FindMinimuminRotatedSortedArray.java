package com.pouzikov.myPackage.InterviewAglorithms.Array;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/


public class FindMinimuminRotatedSortedArray {
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//
//Find the minimum element.
//You may assume no duplicate exists in the array.
//
//Example 1:
//Input: [3,4,5,1,2]
//Output: 1
//
//Example 2:
//Input: [4,5,6,7,0,1,2]
//Output: 0

    public static void main(String[] args) {

    }
//Binary Search Solution, %100 fast, 50% memory
    public int BSsolution(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }



//Simple solution %100 faster, %50 percent
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }




//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
public int leetCodeSolution(int[] nums) {
    // If the list has just one element then return that element.
    if (nums.length == 1) {
        return nums[0];
    }

    // initializing left and right pointers.
    int left = 0, right = nums.length - 1;

    // if the last element is greater than the first element then there is no rotation.
    // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
    // Hence the smallest element is first element. A[0]
    if (nums[right] > nums[0]) {
        return nums[0];
    }

    // Binary search way
    while (right >= left) {
        // Find the mid element
        int mid = left + (right - left) / 2;

        // if the mid element is greater than its next element then mid+1 element is the smallest
        // This point would be the point of change. From higher to lower value.
        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }

        // if the mid element is lesser than its previous element then mid element is the smallest
        if (nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }

        // if the mid elements value is greater than the 0th element this means
        // the least value is still somewhere to the right as we are still dealing with elements
        // greater than nums[0]
        if (nums[mid] > nums[0]) {
            left = mid + 1;
        } else {
            // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
            // the left
            right = mid - 1;
        }
    }
    return -1;
}
}
