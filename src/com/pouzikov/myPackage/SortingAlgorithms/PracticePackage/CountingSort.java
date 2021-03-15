package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

public class CountingSort {
    public static void main(String[] args) {
    int[] array = {45,76,23,89,-98,1789,-90, 178, 289, -192};
    countingSort(array,1,10);
    for(int i = 0; i<array.length;i++){
        System.out.println(array[i]);
    }
    }

    public static void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }

    }
}
