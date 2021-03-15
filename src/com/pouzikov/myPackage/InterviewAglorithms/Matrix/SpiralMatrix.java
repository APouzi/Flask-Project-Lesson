package com.pouzikov.myPackage.InterviewAglorithms.Matrix;
//https://leetcode.com/problems/spiral-matrix/
import java.util.ArrayList;
import java.util.List;
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//Example 1:
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
//
//Example 2:
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]

////https://www.youtube.com/watch?v=3joo9yAZVh8
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {  {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9,10,11,12}
        };
//       matrixSpiralPractice(matrix);
    }






    public static List<Integer> spiralMatric(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0)
            return res;


//        Now we need to have the boundaries
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
//since this is a spiral, what we are going to do is move across to the right, so we are going to have four, for loops
//that consistently move within the boundaries. So we are traversing the first row, but what we are doing is accesing the
// column indices
            for (int i = columnBegin; i <= columnEnd; i++) {
//Since we are only traversing only the first row, and we are changing the column.
                res.add(matrix[rowBegin][i]);
            }
//Once we finish that row(traverse the first row) what we are going to do is move the row up.
            rowBegin++;
//Now we are moving from the begging row boundry to the end row boundry.
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][columnEnd]);
            }
//  Now that we went ot the end of the column boundary, we can decrement it.
            columnEnd--;

// Now we have to do checks to make sure we don't mess up the values. That means we have to unwhined the values
            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (columnBegin <= columnBegin) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][columnBegin]);
                }
            }
            columnBegin++;
        }
        return res;
    }

}
