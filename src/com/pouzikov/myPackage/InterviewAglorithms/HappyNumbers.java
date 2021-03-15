package com.pouzikov.myPackage.InterviewAglorithms;
//https://leetcode.com/problems/happy-number/
import java.util.HashSet;
//Write an algorithm to determine if a number num is "happy". A happy number is a number defined by the following process:
//Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process
//until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers
//for which this process ends in 1 are happy numbers.
//Return True if num is a happy number, and False if not.

//Example:
//Input: 19
//Output: true

//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
public class HappyNumbers {
    public static void main(String[] args) {
        System.out.println(happyNumbers(19));
    }
//Kevin num explanation: https://www.youtube.com/watch?v=gW4hSbRoQoY
    public static boolean happyNumbers(int num){
        HashSet<Integer> record = new HashSet<>();

        while(num != 1 ){
            int current = num;
            int sum = 0;

            while(current != 0){
                sum+= (current%10) * (current%10);//81,2
                current= current/10;//2
            }
            if(record.contains(sum)){
             return false;
            }
            record.add(sum);
            num = sum;
        }
        return true;
    }

}
