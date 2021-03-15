package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55,55, 1, -22};
        bubbleSortPractice(array);
        printArray(array);
    }

//>55, 35, 20, 7, 1, -15, -22,
    public static void bubbleSortPractice(int[] array){
        for(int i = 0; i<array.length;i++){
            for(int j = array.length-1;j>=i;j--){
                if(array[j]>array[i]){
                    swap(array,i,j);
                }
            }
        }

    }















    public static void bubbleSort(int[] array){
        for(int i = 0; i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[i]>array[j])
               swap(array,i,j);
            }
        }
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ ", ");
        }
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
}
