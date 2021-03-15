package com.pouzikov.myPackage.SortingAlgorithms.SelectionSort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        for (int i = array.length - 1; i > 0; i--) {
//Since we haven't actually looked at anything yet, this is our largest element.
            int largestElementSoFar = 0;
//2:10 Now, unlike with bubble sort, we do need to check the element in the last position. In bubble sort, we didn't need
//the equals "<=" because we were comparing "i" against "i+1" and so, the last index we wanted to check was "lastUnsortedIndex-1"
//against lastUnsortedIndex but here we wanna compare every element against whatever's largest, so we need to compare
//this last element as well.
            for (int j = 1; j <= i; j++) {
                if (array[j] > array[largestElementSoFar]) {
                    largestElementSoFar = j;
                }
            }
//Dont forget to swap.
            swap(array,largestElementSoFar,i);
        }
        printArray(array);
    }

    public static void swap(int[] array, int i, int j) {
//  first we check if i =j, if so, then there is nothing for us to do.
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}