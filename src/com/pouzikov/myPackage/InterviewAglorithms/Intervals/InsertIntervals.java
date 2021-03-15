package com.pouzikov.myPackage.InterviewAglorithms.Intervals;



import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertIntervals {
//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). You may assume
//that the intervals were initially sorted according to their start times.
//
//Example 1:
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//
//Example 2:
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//
//NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

//https://www.youtube.com/watch?v=5PfM_LnRU1o

    public static void main(String[] args) {

    }


//    public static int[][] insertPrac(int[][] intervals, int[] newInterval){
//        List<int[]> result = new ArrayList<>();
//
//    }





    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        //Merge the overlapping intervals
        int intervalStart = newInterval[0], intervalEnd = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            intervalStart = Math.min(intervalStart,intervals[i][0]);
            intervalEnd = Math.max(intervalEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[]{intervalStart, intervalEnd});
        while(i < intervals.length && intervals[i][1] > newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}


