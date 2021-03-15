package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
//        long start = System.nanoTime();

        insertionSortPractice(array);
//        long  finish = System.nanoTime();

        printArray(array);
//        System.out.println("Time to completion: " + (finish-start) / 1000.0 + " microseconds");
    }

//>-22, -15, 1, 7, 20, 35, 55
    public static void insertionSortPractice(int[] array) {



    }
    //
    //35,20 -15, 7, 55, 1, -22











//        int[] array = {20, 35, -15, 7, 55, 1, -22};
//    >-22, -15, 1, 7, 20, 35, 55,
    public static void insertionSort(int[] array){
    for(int i = 1; i < array.length; i++){
        int elem = array[i];
        int j;
        for(j = i; j > 0 && (array[j-1]<elem);j--){
            array[j]=array[j-1];
        }
        array[j]=elem;
    }
    printArray(array);
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+", ");
        }
    }


}
