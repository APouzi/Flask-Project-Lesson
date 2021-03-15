package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/longest-increasing-subsequence/
import java.util.*;
//Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//Example 1:
//
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
//Constraints:
//
//    0 <= s.length <= 5 * 104
//    s consists of English letters, digits, symbols and spaces.
//Nick White https://www.youtube.com/watch?v=3IETreEybaA

//If you want to use an ArrayList, you have to use "list.remove(Character.valueOf(word.charAt(pointerA)));"
//https://stackoverflow.com/questions/38861354/removing-a-character-from-an-arraylist-of-characters
//The remove method of the list interface is overloaded and has 2 versions: The first takes an int as an argument and removes
//the item at the specific index. The other takes an Object and removes said object from the list. word.charAt(pointerA)
//Will return a primitive char. So when you pass that char to the remove method the actual implementation that is called
//is the remove(int index) method, because a primitive is not an object but char can be treated as an int
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String word = "pwwkew";
      System.out.println(longestSubstring2(word));

    }


    public static int longestSubstring2(String word){
        return 3;
    }




//        System.out.println(Character.valueOf(test.remove('a')));




//Can either return Hashset or int:
//note we use Hashset because we don't want repeats.
    public static HashSet<Character> longestSubstring(String word) {
        int pointerA = 0;
        int pointerB = 0;
        int maxVal = 0;
        HashSet<Character> rec = new HashSet<>();
        while( pointerB < word.length()){
            if(!rec.contains(word.charAt(pointerB))){
                rec.add(word.charAt(pointerB));
                pointerB++;
                maxVal = Math.max(maxVal,rec.size());
            } else {
                rec.remove(word.charAt(pointerA));
                pointerA++;
            }
        }
        return rec;
    }
}
