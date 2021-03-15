package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//Given an array of integers, find if the array contains any duplicates.
//
//Your function should return true if any value appears at least twice in the array, and it should return false if every
//element is distinct.
//
//Example 1:
//Input: [1,2,3,1]
//Output: true
//
//Example 2:
//Input: [1,2,3,4]
//Output: false
//
//Example 3:
//Input: [1,1,1,3,3,4,3,2,4,2]
//Output: true
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainsDuplicate {
    public static void main(String[] args) {
        List<Integer> record = new ArrayList<>();
        int[] array = {1, 2, 3, 4, 65, 6, 2, 56, 4, 32, 565, 23};
        System.out.println(containsDup(array, record));
    }

    public static boolean containsDup(int[] array, List<Integer> record) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if(record.contains(array[i])){
                return true;
            }
            record.add(array[i]);
        }
        return false;
    }
}
