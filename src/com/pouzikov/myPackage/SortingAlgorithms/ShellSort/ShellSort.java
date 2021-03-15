package com.pouzikov.myPackage.SortingAlgorithms.ShellSort;

public class ShellSort {
    public static void main(String[] args) {
//We don't need swap because this is just a variation of insertion sort.
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
//The first loop we have is just going to intialize the gap value that we have and reduce it. Remember it's going to be
// over two because we are going to start an array.length of 7 over 2, which is 3(7/2 = 3 kinda). We will keep going as
//long as the gap is bigger than 0, because if it is 0, than that means we are going to be comparing elements against
//themselves. So we need a gap of 1,for the final iteration, remember for shell sort. For the final iteration, remember
//for shell sort, the final iteration always has to have a gap of one because we want the final iteration to be the insertion
//sort. On each iteration sort, we are going to divide the gap value, by 2. "gap /= 2" https://stackoverflow.com/questions/13695826/what-is-the-operator-in-java
// aka "gap = gap/2".
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
//Now we are esstionally doing the insertion sort.
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];

                int j = i;
//2:36 so, we are going to say that j is bigger than gap, cause if we hit it, we hit the front of the gap. And so what
//we're saying here, if we were doing the, we're starting out with a gap of 3, so we're starting at 7, just as
//we did with the slides. And in the first iteration, we're gonna compare 7 to [j-gap], right? Because we're
//going to assign 7 to newElement. J is gonna start at three. And we're gonna say if intArray[j-gap] while our
//gap for the first iteration is 3. So if intArray[0] which is 20, is greater than 7 which it is, then we wanna
//shift 7 up 3 positions. So we're going to assign intArray[j] which is 3. So intArray[3] with intArray[3-3](intArray[3-3]
//which intArray[0]. So we're essentially gonna take what's at position 0 and assign it into position
//3. And then once we've done that, we wanna subract the "gap" from "j"(j-=gap) because we're saying that now we're going to want
//to compare "newElement" with whatever comes 3 positions over. Well, we've hit the front of the array at this point. We'll
//loop and we'll say, well "j" has to be greater than or equal to the gap and it isn't because at this point, it's zero.
//And that's because there's no elements to the right past 20. So first, we wanna compare seven against 20. If we could,
//we'd then compare seven against whatever occurs three places in front of 20, but there is nothing.
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
//4:29 And so we're gonna drop out here and what do we wanna do at this point?
                    j -= gap;
                }
//4:34 Just like with insertion sort, while we're basically saying we found the insertion point for 7 when we drop out.
//And so we're going to assign intArray[j] with newElement.
                intArray[j] = newElement;

//4:51-6:33 She walks through the process of the algorithm!
            }

        }
//6:33 Run it!
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
//6:58 We compare the Insertion Sort to Shell Sort
}
