package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/word-ladder/

//Given two words (beginWord and target), and a dictionary's word list, find the length of shortest transformation
//sequence from beginWord to target, such that:
//
//   * Only one letter can be changed at a time.
//   * Each transformed word must exist in the word list.
//
//Note:
//   * Return 0 if there is no such transformation sequence.
//   * All words have the same length.
//   * All words contain only lowercase alphabetic characters.
//   * You may assume no duplicates in the word list.
//   * You may assume beginWord and target are non-empty and are not the same.
//
//Example 1:
//Input:
//beginWord = "hit",
//target = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.


//Example 2:
//Input:
//beginWord = "hit"
//target = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//Explanation: The target "cog" is not in wordList, therefore no possible transformation.
//Nick white Explanation:    https://www.youtube.com/watch?v=M9cVl4d0v04&t=22s

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));//Ans = 5
        String beginWord = "hit";
        String target = "cog";
        System.out.println(ladderPrac(beginWord,target,list));
    }

    public static int ladderPrac(String beginWord, String target, List<String> list) {
       return 3;
    }







    public static int ladderLengthPrac(String beginWord, String target, List<String> wordList){
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        if(!set.contains(target)){
            return 0;
        }
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] wordChar = currentWord.toCharArray();
                for (int j = 0; j < wordChar.length; j++) {
                    char originalChar = wordChar[j];
                    for (char c = 'a'; c<='z' ; c++) {
                        if(wordChar[j]==c) continue;
                        wordChar[j] = c;
                        String newWord = String.valueOf(wordChar);
                        if(newWord.equals(target)) return level+1;
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordChar[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }



//How do you know when to use breadth first search? when you look at the problem and you can imagine
//as this to be alot of nodes looking at a graph, you're starting at the begginng point, you're trying to reach an
//ending point,  you want to know how many levels or transformations you're going to need to get to the ending point.

    public static int ladderLength(String beginWord, String target, List<String> wordList){
//When doing BFS usually we use a Que, because its a line. What we want to do here is check each word and in a list the
//time complexity would be alot worse than it would be in a set
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
//Then we can check if the set contains the ending word. IF it doesn't that means the ending state isn't in the word list.
//That would mean that "cog" the target, wouldn't be in the list. Which means we return 0 if there is no transformation
//sequence
        if(!set.contains(target)){
            return 0;
        }
//Now we are going to set up our queue, also: https://stackoverflow.com/questions/15608026/difference-in-linkedlist-queue-vs-list
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
//The level that we are starting off with is one and we are going to increment it.
        int level = 1;

        while(!queue.isEmpty()){
//This is how we do our breadth search.
// What we are going to do is just check every letter from a to z by a letter at a time and if that word exists, then we
//assign it to our word. Then if we find the word, we also want to check if that is the "target" and if it is then we
//want to increment the level(level++).
            int size = queue.size();
            for (int i = 0; i < size; i++) {
//This outer loop will poll out all the strings. Then we turn these words into char arrays. We then go through each letter.
//or character and see if the any of it matches the word.
                String currentWord = queue.poll();
                char[] wordChar = currentWord.toCharArray();
                for (int j = 0; j < wordChar.length; j++) {
//This is where we try out ever char in the alphabet below and see which one matches.
                    char originalChar = wordChar[j];
                    for (char c = 'a'; c<='z' ; c++) {
//Here we are going to see if the character is the same and if it is, then we will continue the loop.
                        if(wordChar[j]==c) continue;
                        wordChar[j] = c;
                        String newWord = String.valueOf(wordChar);
                        //Here we return level +1 because we found the target.
                        if(newWord.equals(target)) return level+1;
//If we dont find t he word we can at least find the transformation on the way to the word.
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordChar[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
