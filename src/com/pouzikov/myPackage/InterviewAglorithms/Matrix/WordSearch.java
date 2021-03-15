package com.pouzikov.myPackage.InterviewAglorithms.Matrix;
//https://leetcode.com/problems/word-search/

//Given a 2D board and a word, find if the word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
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
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
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
//static boolean[][] visited;
//public boolean

    public static void main(String[] args) {
        char[][] list = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        WordSearch test = new WordSearch();
        System.out.println( test.exists(list,word));
    }
//    Because this is recursive, we don't want to keep looking over things we have already looked at.
    boolean visited[][];

    public boolean exists(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        visited = new boolean[rows][columns];
//First we want to loop through the 2D array.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
//Now we are going to do a seperate method where it's going to do recursive calls asking if the words horizontally or
//vertically neighboring one another are going to. If we see the first character of the word, well call the search method
//and if that gives us true we then call the wordSearch() which will find the rest of the word and this will get us true.
//Then we return true.
            if(word.charAt(0) == board[i][j] && wordSearch(i,j,0,word, board)){
                return true;
            }
            }
        }
        return false;
    }
    public boolean wordSearch(int i, int j, int index,  String word, char[][] board){


//But why do we have the index? because if index is as long as the word, it means we found the full word
    if (index==word.length())
        return true;
//Now we gotta do the boundry checks. So what that means is
    if(i<0 || i >= board.length|| j<0 || j >= board[i].length || word.charAt(index) != board[i][j]) {
        return false;
    }
    visited[i][j] = true;
//This is going to be four recursive calls. This recurses on the column to the right and left and rows above and below.
        if(
                wordSearch(i+1,j, index+1, word, board) ||
                wordSearch(i-1,j,index+1,word,board) ||
                wordSearch(i,j+1,index+1,word,board) ||
                wordSearch(i, j -1, index+1,word,board)
        ){
            return true;
        }

        visited[i][j] = false;
        return false;
    }


}
