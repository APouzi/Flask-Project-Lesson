package com.pouzikov.myPackage.InterviewAglorithms.Array.Practice;
//Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
//appears at least twice in the array, and it should return false if every element is distinct.

//[1,2,3,1] > true
//[1,2,3]> false
//remember edge cases
import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] array = {1,3};
        int[] array2 = {1,2,3,4,65,6,2,56,4,32,565,23};
        System.out.println(conDup(array2));
    }












    public static boolean conDup(int[] array){

        Arrays.sort(array);
        for(int i = 0;i<array.length-1;i++){
            if(array[i]==array[i+1])
                return true;
        }
        return false;
    }
}
