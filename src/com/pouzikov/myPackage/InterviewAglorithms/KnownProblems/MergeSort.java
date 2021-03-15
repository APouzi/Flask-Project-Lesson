package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {1,42,2,4,1,4143,-987,-234,43,1,5};
        mergeSort(array,0,array.length-1);
        printArray(array);
    }

    public static void mergeSort(int[] array, int start, int end){
        if( start < end){
            int mid = (start + end)/2;

            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            mergeOfSort(array,start,mid,end);
        }
    }

    public static void mergeOfSort(int[] array, int start, int mid, int end){
      int pSL = mid - start + 1;
      int pSR = end - mid;

      int[] leftArray = new int[pSL];
      int[] rightArray = new int[pSR];

        for (int i = 0; i < pSL; i++) {
            leftArray[i] = array[start+i];
        }
        for (int i = 0; i < pSR; i++) {
            rightArray[i] = array[mid+1+i];
        }

        int i = 0, j =0, index = start;
        while(i < pSL && j < pSR){
            if(leftArray[i]<=rightArray[j]){
                array[index]=leftArray[i];
                i++;
            }else {
                array[index]=rightArray[j];
                j++;
            }
            index++;
        }

      while(i < pSL){
          array[index] = leftArray[i];
          i++;
          index++;
      }
      while (j < pSR){
          array[index] = rightArray[j];
          j++;
          index++;
      }

    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.println(i);
        }
    }
}
