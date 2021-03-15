package com.pouzikov.myPackage.InterviewAglorithms.Matrix;
//https://leetcode.com/problems/spiral-matrix-ii/
import java.util.*;
//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//Example:
//
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]


//https://www.youtube.com/watch?v=NO1zLdOwgR0
public class SpiralMatrixII {
    public static void main(String[] args) {
    int[][] matrix = generateMatrix(3);
        List<Integer> res = new ArrayList<>();
        System.out.println();

    }

    public static int[][] generateMatrix(int n){

        int[][] res = new int[n][n];

        int rowBegin = 0;
        int rowEnd = n-1;//n-1 cause "array.length-1"
        int columnBegin = 0;
        int columnEnd = n-1;

//here is the different part, we are going to have a counter, this counter is going to be the numbers in the array "1,2,3..."
        int counter = 1;

        while(rowBegin <= rowEnd && columnBegin <= columnEnd){
//So now we are going to actually make the matrix, unlike the other one which has us do any given matrix.
            for(int i = columnBegin;i <= columnEnd;i++){
                res[rowBegin][i] = counter;//you can also do counter++ here too
                counter++;
            }

            rowBegin++;
            for(int i = rowBegin; i<=rowEnd; i++){
                res[i][columnEnd]=counter++;
            }
            columnEnd--;

            if(rowBegin<=rowEnd){
                for(int i=columnEnd; i>=columnEnd;i--){
                    res[rowEnd][i] = counter++;
                }
            }
            rowEnd--;

            if(columnBegin<=columnEnd){
                for(int i = rowEnd;i>=rowBegin;i--){
                    res[i][columnBegin]= counter++;
                }
            }
            columnBegin++;
        }
        return res;
    }
}
