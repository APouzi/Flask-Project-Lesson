package com.pouzikov.myPackage.SortingAlgorithms.BubbleSort;
//17-1:00 it partitions the array into a sorted partition and an unsorted partition and this is a logical partitioning so
//we don't create completely separate array instances
//17-7:29 It's an in palce algo, We don't have to create another array in order to perform this sort
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {20,35,-15,7,55,1,-22};
//18-4:13 the actual bubble sort, this is one implementation. There are others. This version is going from index 6 to 0
//(right to left), if we are at 0, we can stop because the array is sorted.
            for (int i = array.length - 1; i > 0;i--){
//18-5:55 That was the outer loop, now we have to get the inner loop.
                for(int j = 0; j<i; j++){
                    if(array[j]>array[j+1]) {
                        swap(array, j, j+1);
                    }
                }
        }
        printArray(array);
    }
public static void swap(int[] array, int i, int j){
//  first we check if i =j, if so, then there is nothing for us to do.
        if(i == j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j]= temp;
}

public static void printArray(int[] array){
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
}
    }



