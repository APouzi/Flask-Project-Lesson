package com.pouzikov.myPackage.InterviewAglorithms.String;

public class StringIsPalindrone {
    public static void main(String[] args) {
        System.out.println(isPalindromeWithTwoPointer("racecar"));
    }
    
    public static boolean isPalindromeWithTwoPointer(String word){
            char[] chars = word.toCharArray();
            for (int i = 0; i < (chars.length / 2); i++) {
                if (chars[i] != chars[(chars.length - i - 1)])
                    return false;
            }
            return true;
        }
}
