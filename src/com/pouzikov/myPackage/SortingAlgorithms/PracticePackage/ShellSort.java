package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
       long start = System.nanoTime();

        shellSortPractice1(array);
        long  finish = System.nanoTime();
        printArray(array);

        System.out.println("Time to completion: " + (finish-start) / 1000.0 + " microseconds");
    }

    public static void shellSortPractice1(int[] array){


    }









    public static void shellSortPractise(int[] array){
    for(int gap = array.length/2;gap>0; gap--){
        for(int i = gap; i<array.length;i++){
            int elem = array[i];
            int j = i;
            while(j>0 && array[j-gap]>elem){
                array[j]=array[j-gap];
                j-=gap;
            }
        }
    }
    }
















    public static void shellSort(int[] array){
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;

            }
        }
        printArray(array);
        }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ ", ");
        }
    }
}

