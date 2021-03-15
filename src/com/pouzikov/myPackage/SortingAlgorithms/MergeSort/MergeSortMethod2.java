package com.pouzikov.myPackage.SortingAlgorithms.MergeSort;

public class MergeSortMethod2 {
    // Main function that sorts array[start..end] using
    // merge()
    public static void main(String[] args) {
        int[] array = {12,45,-3,6,8,9};

        sort(array,0, array.length-1);
        for(int p = 0; p< array.length;p++){
            System.out.print(array[p] + " ");
        }

    }

   public static void sort(int[] array, int start, int end)
    {
        if (start < end) {
            // Find the middle point
            int mid = (start + end) / 2;

            // Sort first and second halves
            sort(array, start, mid);
            sort(array, mid +1, end);

            // Merge the sorted halves
            mergeMethod2(array, start, mid, end);

        }
    }


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
            } else {
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
