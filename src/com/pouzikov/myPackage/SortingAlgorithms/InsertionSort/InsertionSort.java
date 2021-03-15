package com.pouzikov.myPackage.SortingAlgorithms.InsertionSort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
//00:00 We have to remember that the loop starts out at "1", because it assumes index 0 is the "sorted partition".
            for(int i = 1;i<array.length;i++){
// The first thing we are going to do is save the value of the element
    int newElement = array[i];
    int j; //We also are going to need declare j, outside the loop because we need it outside the loop.
//1:50 So we're gonna say for "j=i" because when we start out, the element we want to insert is that first inserted index
// We are also going to continue to loop as long as i is greator than 0.
//2:33 So what is this doing?
//Just to go over this again, we want to keep looking for the insertion position  as long as we haven't hit the front of
//the array  because if we hit the front of the array(j>0), it means that the element we're trying to insert  is the smallest
//element we've seen so far and the correct insertion position is zero.  And we wanna keep looking as long as the element
//we're looking at in the sorted partition  is greater than the one we're trying to insert,  because if the element at
//"j-1" is greater than the element we're trying to insert, then we still haven't found the correct insertion position.
//So the moment we hit the front of the array,or the moment we hit an element that is less than or equal to the element
//we're trying to insert, we have found the correct insertion position.
                for(j = i; j>0 && (array[j-1] > newElement);j--){
//Now we want to shift the element to the right. This is where we do the shifting, left to right that is.
                    array[j] = array[j-1];

                }
//5:26 Now when we find the correct position, what do we need to do? Well, our final step when we drop out of this loop
//is to assign intArray i with newElement,
                array[j]=newElement;
            }
            printArray(array);
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
