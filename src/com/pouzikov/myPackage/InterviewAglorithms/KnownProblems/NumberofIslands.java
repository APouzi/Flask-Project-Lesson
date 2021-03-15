package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands. An island is surrounded by
//water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
//are all surrounded by water.


//Example 1:
//Input: grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//Output: 1


//Example 2:
//Input: grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//Output: 3


//Constraints:
//    m == grid.length
//    n == grid[i].length
//    1 <= m, n <= 300
//    grid[i][j] is '0' or '1'.

//Nick White Solution: https://www.youtube.com/watch?v=U6-X_QOwPcs&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&pbjreload=101
public class NumberofIslands {
    public static void main(String[] args) {
        char[][] grid = {
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
        };
        System.out.println(NISPrac(grid));
    }

    public static int NISPrac(char[][] grid){
      int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    count += 1;
                    callBFSPrac(grid,i,j);
                }
            }
        }
        return count;
    }

    public static void callBFSPrac(char[][] grid,int i,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >=grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        callBFS(grid,i+1,j);
        callBFS(grid,i-1,j);
        callBFS(grid,i,j+1);
        callBFS(grid,i,j-1);


    }







    public static int NIS(char[][] grid){

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    count += 1;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void callBFS(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j <0 || j >=grid[i].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        callBFS(grid,i+1,j);
        callBFS(grid,i-1,j);
        callBFS(grid,i,j+1);
        callBFS(grid, i,j-1);
    }
}