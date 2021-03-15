package com.pouzikov.myPackage.SortingAlgorithms.MergeSort;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {
//If the array is smaller than 2, than this will allow for us to move on.
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {
//8:49 If this is the case here, we don't have to do any merging. what is it doing? Well, as we've said, we're always merging
//sorted arrays. So, when we call merge the left partition that we're merging is sorted. And the right partition is sorted.
//And we know that mid is the first element in the right side and it's one greater than the last element in the left side.
//And so, input mid minus one, is the last element in the left partition. And input mid is the first element in the right
//partition. Now, if the last element in the left partition is less than or equal the first element in the right partition
//that means all the elements in the left partition are less than or equal than the smallest element in the right partition,
//because both of these guys are sorted. And so, if the last element in the left partition is, let's say 20, and the first
//element in the right partition is 25, then we know that all the elements in the right partition are gonna be greater
//than or equal to all the elements in the left partition, because these are sorted. Basically this stops us from merging
//together arrays when they are already have it sorted and there is no need to continue that
        if (input[mid - 1] <= input[mid]) {
            return;
        }
//12:39 If line 39 is not the case, that means we have some elements in that are greator in the right array. So we are
//going to initialize some elements.
        int i = start;
        int j = mid;
//This is going to keep track of where we are int he temporary array.
        int tempIndex = 0;

//13:11 Now we are going to create our new array, using length of "end - start". we need this to be large enough to hold
//the number of elements in the left and right partitions, and so, if we're doing the whole array, end will be seven and
//start will be zero so we'll end up with a integer array of seven and that's what we want.
        int[] temp = new int[end - start];
//13:37 we're going to step through the left and right arrays and we're gonna compare whatever is at index I, in the left
//array, with whatever is at index J, in the right array. And we're going to write the smaller of the two into the current
//position in temp. Which we're keeping track of with temp index.
        while (i < mid && j < end) {
//13:59 So we are going to compare the start i which is start, to to the end which is "j". So as soon as we've finished
//traversing the left array we wanna drop out or as soon as we finish traversing the right array, we wanna drop out. So
//once we have finished completely traversing either the left or the right array, we're gonna drop out of the loop, and
//don't worry, we'll handle any left over elements in a minute. Note, that this algorithm is stable, if we didn't have
//the "=" here, this wouldn't be stable.
//15:38 And so if input I is less than or equal to input J, we're gonna assign input I to the current position in temp[tempIndex++]
//and then we're gonna increment the temp index and we're gonna increment I. Basically, temp[tempIndex++] is going to be
//one of the two options we see below.
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
//16:34 Now because we're dropping out of the loop, when we've completely traversed the one of the arrays, the other array
//or partition, sub array,  however you wanna call it,  the other one will have some elements left over  that we have not
//copied in to temp  and so we have to handle that now.  And this just going to be the second optimization.  This is going
//to be handling the remaining elements  in the array that we have in traverse.  Now the optimization is that if we have
//elements  remaining in the left partition,  we have to copy them into the temp array.  But, if we have elements remaining
//in the right partition  we don't have to do anything. And you might be thinking, well why not? Its kind of the same
//situation that we had  with the first optimization. When we're copying the elements back,  we're copying them back into
//the positions  that are covered by the left and right partitions, so. Okay, so let me do an example on the fly here.
//17:34 So basically we don't have to worry about the right array as much because during the merge, it will take care of
//itself

//21:50 So we are going to be using the source "Input" which is the array, @21:50 we are going to start at the "i" position,
//which is the 2nd parameter. We then have the destination which is the array we are working with. 22:03 we're gonna copy
//to "start + tempIndex". This is our destination index. and temp index has basically counted how many elements we've handled.
//And so the destination position for any elements in the left array that are gonna basically jump over all of the elements
//in the temporary array is star plus temp index. So if we're merging two element arrays and we've copied three elements
//into the temporary array and we have that one left over element in the left array, the left partition that we haven't
//handled, we'll add three to the start index and so it'll be copied into the original input array after the elements
//that we're gonna copy in from the temp array.
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }






    public static void mergeMethod2(int[] arr, int low, int mid, int high) {

        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = low;
        int j = mid;
        int[] temp = new int[high - low];

        int k = 0;
        while (i < mid && j < high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }

            if (arr[j] <= arr[i]) {
                //using a second "if" condition instead of "else if" will give a better time complexity as the array increases in size
                temp[k++] = arr[j++];
            }

        }

        //Copying remaining elements from the "arr" to temp array
        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j < high) {
            temp[k++] = arr[j++];
        }

        //copying temp back to original array
        k = 0;
        for (int p = low; p < high; p++) {
            arr[p] = temp[k++];
        }
    }
}
