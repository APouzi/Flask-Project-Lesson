//https://leetcode.com/problems/reverse-integer/
package com.pouzikov.myPackage.InterviewAglorithms;
//Given a 32-bit signed integer, reverse digits of an integer.
//
//Example 1:
//Input: 123
//Output: 321
//
//Example 2:
//Input: -123
//Output: -321
//
//Example 3:
//Input: 120
//Output: 21
//
//Note:
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
//[−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
public class ReverseInteger {
    public static void main(String[] args) {
    reverse(19);
    }

    public static void reverse(int x){
        int prevRev = 0 , rev= 0;//9
        while( x != 0){
            rev= (rev*10) + (x % 10); //9,
//            if( ((rev - x % 10) / 10) != prevRev){
//                return;
//            }
//            prevRev = rev;
            x= x/10;//1
        }
        System.out.println(rev);
    }
}
