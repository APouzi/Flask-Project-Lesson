package com.pouzikov.myPackage.SortingAlgorithms.CountingSort;

public class CountingSort {
    public static void main(String[] args) {
        int[] intArray = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

        countingSort(intArray, 1, 10);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
//We are going to put in a range of min to max, because cunting sort falls within that range.
    public static void countingSort(int[] array, int min, int max) {
//first thing we are to do is create the counting array. so if max = 10 and min = 1, then we are going to create an array,
//then that means its going to be "10-1 = 9...+1" which is what we want for the size.

        int[] countArray = new int[(max - min) + 1];
//Now we want to traverse this array.
        for (int i = 0; i < array.length; i++) {
//1:56 The way that we calculate where each value is placed is by this. So, for example, let's say input i is equal to 5,
//so let's say we're at the point where we're counting this one. To figure out which element we should increment in the
//countArray, we would say 5 - 1 because that's our minimum and so, we'd increment countArray[4] because remember,
//we could have values let's say going from 10 to 20 and in that case, the countArray would be 11 elements long and so,
//we need to translate the values 10 to 20 to indices 0 to 10 and that's what we're doing here.and we can do that just
//by subtracting out the minimum from whatever value we're counting and so, to count ones, if we got a 1, we'd subtract
//1 - 1 so we'd increment element zero. If we got a two, 2 - min is 1 and so, we'd increment element one. If we got a
//10, 10 - 1 is 9, and we'd increment element nine in the countArray. And so, all this is doing is translating the value
//we wanna count into its index in the countArray. And what do we wanna do? We wanna increment that position and so, that's
//all we do here. So, this is the counting phase.
            countArray[array[i] - min]++;// countArray[array[i] - min] = countArray[array[i] - min]+1;
        }
//3:45 Once we finish counting we want to write the values back into the input array. So, what are we doing here? J is
//the index we're going to use to write to the input array And i is the index that we're going to use to traverse the countArray.
//We're setting i to min and i less than or equal to max because as you'll see, because we're doing it this way, we can
//just write the value of i back to the input array on each iteration.

//  2, 5, 9, 8, 2, 8, 7, 10, 4, 3
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                array[j++] = i;
                countArray[i - min]--;
            }
        }
 //5:01 So, what's going on here? What we're doing here is remember that each element in the countArray has a count and that
//count can be greater than 1. So, let's go through this for the number of 2s because we know we have two 2s in our
//array and the count of 2s is kept in countArray one. So, when i is 2, we say while countArray 2-1 which
//is countArray 1 is greater than 0, we wanna keep writing 2s to the input array because at this point, we're writing
//the number of 2s. And so, the first thing we do is we write a 2 to the input array and then we need to decrement the count.
//We've already written one 2 and so, we only have another 2 left to write and so, we started with countArray 1 = 2
//because we have two 2s, we write one of the 2s to the input array and then we decrement the count to 1 because
//we only have one 2 remaining. We loop around, countArray one is still greater than 0, so we're gonna write another
//2 and then we're gonna decrement the count again and at this point, the count will be zero because we've written both
//of the twos back to the input array and so, when we loop back around, at this point countArray[1] will be equal to 0
//and we drop out of the loop and then i will be incremented to 3 and we enter this loop to write the number of 3s
//and once again, each time we write a 3, , so each time we write a three, the count will be decremented by one until
//we've written all the 3s and then we'll loop around and we'll write the 4s. So, we've written the loop this way starting
//i at min because then we can just when we're writing out the number of 1s, i will be one, when we're writing out the
//number of twos, i will be two. So, we can just stick i in and subtract here. We could have started i at 0 but then we'd
//need to do a different type of calculation here. We'd need to figure out what value we're writing. So, I think it's
//clear to set i to min because then we know that on the first iteration we're writing out one, the second iteration we're
//writing the 2s, the third iteration we're writing the 3s et cetera and of course j is keeping track of where we are in
//the input array.

    }
}
