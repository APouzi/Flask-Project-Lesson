package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22,89,22,-7};
        selectionSort2(array);
        printArray(array);
    }

//>55, 35, 20, 7, 1, -15, -22
    public static void selectionSort2(int[] array){
        for(int i = array.length-1;i>0;i++){
            int point = 0;
            for(int j = 0; i <array.length;i++){
                if(array[i]>=array[j]){
                    point = j;
                }
            }
            swap(array,i,point);
        }
    }












    public static void selectionSort(int[] array){
        for(int i=0;i<array.length;i++){
//make sure to know that you need to flip the caps of the sortedElement
            int sortedElement = array.length-1;//if line 35 uses "array.length-1" for "i", then make sure sorted element is "0" or "i"
            for (int j =array.length-1;j>=i;j--){
                if(array[j]>array[sortedElement]){
                    sortedElement = j;
                }

            }
            swap(array,sortedElement,i);
        }
        printArray(array);
    }

    public static void bubbleSort(int[] array){

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
            System.out.print(array[i]+", ");
        }
    }
}
