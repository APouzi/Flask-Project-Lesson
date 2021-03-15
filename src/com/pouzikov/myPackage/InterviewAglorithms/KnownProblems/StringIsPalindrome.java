package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

public class StringIsPalindrome {
    public static void main(String[] args) {
        String word = "racecar";

        System.out.println(PalinDromeQ(word));

    }

    public static boolean PalinDromeQ(String word){
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(word.length() - i - 1)){
                return false;
            }
        }
        return true;
    }














    public static boolean isPalindrome(String word){

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)!=word.charAt(word.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    }

