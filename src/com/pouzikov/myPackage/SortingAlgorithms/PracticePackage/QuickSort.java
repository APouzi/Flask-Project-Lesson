package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {12,5,6,-17,-198,-67,93,43,23};
quickSort(array,0,array.length);
        printArray(array);
    }


    public static void quickSort(int[] array, int start, int end){


    }

    public static int partition(int[] array, int start, int end) {
      return 1;
    }


//    public static void quickSortPerfect(int[] array, int start, int end) {
//
//    }
//
//
//
//
//
//
//    public static int partitionPerfect(int[] array, int start, int end) {
//        // This is using the first element as the pivot
//        int pivot = array[start];
//        int i = start;
//        int j = end;
//        while (i < j) {
//            while (i < j && array[--j] >= pivot);
//            if (i < j) {
//                array[i] = array[j];
//            }
//            while (i < j && array[++i] <= pivot);
//            if (i < j) {
//                array[j] = array[i];
//            }
//
//        }
//        array[j] = pivot;
//        return j;
//
//    }
        public static void printArray (int[] array){
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
    }

