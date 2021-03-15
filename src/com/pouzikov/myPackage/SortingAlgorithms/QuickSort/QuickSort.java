package com.pouzikov.myPackage.SortingAlgorithms.QuickSort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 20, 35, -15, 7, 55, 1, -22 };

        quickSort(array, 0, array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        // This is using the first element as the pivot
        int pivot = array[start];
        int i = start;
        int j = end;
//4:27 Now "i" is going to traverse left from right and "j" is going from right to left. When they meet, we want to drop out.
        while (i < j) {

//NOTE: empty loop body 5:18 so we are using this empty loop to decrement "j" until we find an element that is less-than
//the pivot or "j" crosses "i". When we fall out this loop, we have to make sure that "i" is smaller than "j" then we assign
//array[i] to array[j]. Note: the prefix of "--j" means that we are going to be decreasing the j by 1 before the comparison,
//also we do "--j" because we start at 0
            while (i < j && array[--j] >= pivot);
            if (i < j) {
                array[i] = array[j];
            }
//6:39 Now we want to traverse "i", from left to right, that is looking for something that is greator-than the pivot.
// 8:20ish Remember we are incrementing first because we want that to compare the one after, and that's why we use prefix.
            // NOTE: empty loop body
            while (i < j && array[++i] <= pivot);
            if (i < j) {
                array[j] = array[i];
            }

        }
//9:05 when we drop out this loop, at this point the value of "j" is where we would want to insert the pivot.
        array[j] = pivot;
        return j;

    }
}
