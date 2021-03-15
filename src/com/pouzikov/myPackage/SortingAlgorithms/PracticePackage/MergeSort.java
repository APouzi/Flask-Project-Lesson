package com.pouzikov.myPackage.SortingAlgorithms.PracticePackage;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        mergeSort1(intArray, 0, intArray.length-1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }
   // int[] intArray = { 20, 35, -15 , 7, 55, 1, -22 };
    public static void mergeSort1(int[] array, int start, int end) {

    }

    public static void sortofMerge(int[] array, int start,int mid, int end){


    }











    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;//(0+7 / 2)
        mergeSort(input, start, mid);//references 20 to 7 |
        mergeSort(input, mid, end);//references  7 to -22 |
        mergeMethod2(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeMethod2(int[] array, int start, int mid, int end)
    {
        // Find sizes of two subarrays to be merged
        int subArrayL = mid - start + 1;
        int subArrayR = end - mid;

        /* Create temp arrays */
        int[] leftTempArray = new int[subArrayL];
        int[] rightTempArray = new int[subArrayR];

        /*Copy data to temp arrays*/
        for (int i = 0; i < subArrayL; i++)
            leftTempArray[i] = array[start + i];
        for (int j = 0; j < subArrayR; j++)
            rightTempArray[j] = array[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int index = start;
        while (i < subArrayL && j < subArrayR) {

            if (leftTempArray[i] <= rightTempArray[j]) {
                array[index] = leftTempArray[i];
                i++;
            }
            else {
                array[index] = rightTempArray[j];
                j++;
            }
            index++;
        }

        /* Copy remaining elements of leftTempArray[] if any */
        while (i < subArrayL) {
            array[index] = leftTempArray[i];
            i++;
            index++;
        }

        /* Copy remaining elements of rightTempArray[] if any */
        while (j < subArrayR) {
            array[index] = rightTempArray[j];
            j++;
            index++;
        }

    }
}
