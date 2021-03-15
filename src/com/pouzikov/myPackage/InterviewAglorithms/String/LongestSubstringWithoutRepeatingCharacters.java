package com.pouzikov.myPackage.InterviewAglorithms.String;
//Leetcode #3
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

//Given a string s, find the length of the longest substring without repeating characters.
//
//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//Example 2:
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//Example 3:
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//Example 4:
//Input: s = ""
//Output: 0
//
//
//
//Constraints:
//
//    0 <= s.length <= 5 * 104
//    s consists of English letters, digits, symbols and spaces.

//https://www.youtube.com/watch?v=3IETreEybaA&t=422s
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String test = "pwwkew";
        longestSubstring(test);

    }

    public static void longestSubstring(String word){
    int pointerA = 0;
    int pointerB = 0;
    int max = 0;

        HashSet<Character> charSet = new HashSet<>();
        while(pointerB > 0) {
            if (!charSet.contains(word.charAt(pointerB))){
                charSet.add(word.charAt(pointerB));
                pointerB++;
                max = Math.max(charSet.size(),max);
            }else{
                charSet.add(word.charAt(pointerA));
                pointerA++;
            }
        }
    }
}
