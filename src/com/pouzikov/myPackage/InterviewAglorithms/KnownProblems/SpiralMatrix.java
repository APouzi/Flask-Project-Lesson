package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2, 3, 4},
                          {5,6, 7, 8},
                          {9,10,11,12}};

        int[][] matrix2 = {{1},{2},{3}};
//        System.out.println(spiralMatrix2(matrix));
    }


//    public static List<Integer> spiralMatrix2(int[][] matrix) {
//
//        return list;
//    }

//                {1, 2,  3,  4, 5},
//                {6,  7,  8, 9, 10},
//                {11, 12, 13, 14, 15}
    public static List<Integer> circularMatrix (int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int rowB = 0, rowE = matrix.length-1, colB = 0, colE = matrix[0].length-1;

        while(rowB <= rowE && colB <= colE) {
            for (int i = colB; i <= colE; i++) {
                list.add(matrix[rowB][i]);
            }
            rowB++;
            for (int i = rowB; i <= rowE; i++) {
                list.add(matrix[i][colE]);
            }
            colE--;
            if(rowB<= rowE){
                for (int i = colE; i >= colB; i--) {
                list.add(matrix[rowE][i]);
                }
            }
            rowE--;
            for (int i = rowE; i >= rowB; i--) {
                list.add(matrix[i][colB]);
            }
            colB++;
        }
        return list;
    }















        public static List<Integer> spiralMatrix ( int[][] matrix){
            List<Integer> rec = new ArrayList<>();
            int rowB = 0, rowE = matrix.length - 1, columnB = 0, columnE = matrix[0].length - 1;

            while (rowB <= rowE && columnB <= columnE) {

                for (int i = columnB; i <= columnE; i++) {
                    rec.add(matrix[rowB][i]);
                }
                rowB++;
                for (int i = rowB; i <= rowE; i++) {
                    rec.add(matrix[i][columnE]);
                }
                columnE--;
                if (rowB <= rowE) {
                    for (int i = columnE; i >= columnB; i--) {
                        rec.add(matrix[rowE][i]);
                    }
                }
                rowE--;
                if (columnB <= columnE) {
                    for (int i = rowE; i >= rowB; i--) {
                        rec.add(matrix[i][columnB]);
                    }
                }
                columnB++;
            }
            return rec;
        }

    }
