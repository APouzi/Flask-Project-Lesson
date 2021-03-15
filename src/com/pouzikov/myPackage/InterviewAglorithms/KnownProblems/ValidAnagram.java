package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/valid-anagram/
//Given two strings s and t , write a function to determine if t is an anagram of s.
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false
//
//Note:
//You may assume the string contains only lowercase alphabets.
//
//Follow up:
//What if the inputs contain unicode characters? How would you adapt your solution to such case?
import java.util.Arrays;


public class  ValidAnagram {
    public static void main(String[] args) {
    String word1 = "racecar";
    String word2 = "carrace";

        System.out.println(validAnagram(word1,word2)) ;
    }

    public static boolean validAnagram(String word, String wordCheckTo){
        char[] test = new char[26];

        return true;

    }





    public static boolean validAnagram2(String word, String wordCheckto){

        if(word.length() != wordCheckto.length()){
            return false;
        }
        int size = word.length();
        char[] count = new char[size];
        char[] count2 = new char[size];

        Arrays.sort(count);
        Arrays.sort(count2);

        for(int i: count){
            if(count[i]!=count2[i]){
                return false;
            }

        }
        return true;
    }
}
