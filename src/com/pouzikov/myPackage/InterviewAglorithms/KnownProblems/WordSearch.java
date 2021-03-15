package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//https://leetcode.com/problems/word-search/

//Given a 2D board and a word, find if the word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cell, where 'adjacent' cells are those horizontally
//or vertically neighboring. The same letter cell may not be used more than once.
//
//Example:
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = 'ABCCED', return true.
//Given word = 'SEE', return true.
//Given word = 'ABCB', return false.
//
//Constraints:
//
//    board and word consists only of lowercase and uppercase English letters.
//    1 <= board.length <= 200
//    1 <= board[i].length <= 200
//    1 <= word.length <= 10^3
//This problem is similar to number of island leetcode problem. Remember that the element has to be touching the last
//chosen element
//https://www.youtube.com/watch?v=m9TrOL1ETxI
public class WordSearch {

    public static void main(String[] args) {
         char[][] list = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
         
         char[][] lists = {
                 {'A','B','C','E'},
                 {'S','F','C','S'},
                 {'A','D','E','E'}
         };
        String word = "ABF";

//        System.out.println(existsP(lists,word));
    }












//    Because this is recursive, we don't want to keep looking over things we have already looked at.
    public static boolean[][] visited2;
    public static boolean exists(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
//    This is the same thing as "Boolean[][] visited2 = new boolean[rows][columns];" except the first half is on line 77
//    and the rest is below
        visited2 = new boolean[rows][columns];
//First we want to loop through the 2D array.
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[i].length; j++){
//Now we are going to do a seperate method where it's going to do recursive calls asking if the words horizontally or
//vertically neighboring one another are going to. If we see the first character of the word, well call the search method
//and if that gives us true we then call the wordSearch() which will find the rest of the word and this will get us true.
//Then we return true.
                if((word.charAt(0) == board[i][j]) && wordSearch(board, word, i, j, 0)){
                    return true;
                 }
            }
        }
        return false;
    }


    public static boolean wordSearch(char[][]board, String word, int i, int j, int index){
//But why do we have the index? because if index is as long as the word, it means we found the full word
    if (index==word.length())
        return true;
//Now we gotta do the boundry checks. So what that means is
if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited2[i][j]){
        return false;
    }
    visited2[i][j] = true;
//This is going to be four recursive calls. This recurses on the column to the right and left and rows above and below.

            if(wordSearch(board, word, i-1, j, index+1) ||
                    wordSearch(board, word, i+1, j, index+1) ||
                    wordSearch(board, word, i, j-1, index+1) ||
                    wordSearch(board, word, i, j+1, index+1)){
            return true;
        }
//This is here because it resets the visited when the recursion happens.
        visited2[i][j] = false;
        return false;
    }


}
