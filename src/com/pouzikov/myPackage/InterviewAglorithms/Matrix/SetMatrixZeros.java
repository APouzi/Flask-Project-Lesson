package com.pouzikov.myPackage.InterviewAglorithms.Matrix;
//https://leetcode.com/problems/set-matrix-zeroes/ - Medium
//CHECK IMAGES IN LEETCODE FOR BETTER EXAMPLES
//Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
//
//Follow up:
//
//    A straight forward solution using O(mn) space is probably a bad idea.
//    A simple improvement uses O(m + n) space, but still not the best solution.
//    Could you devise a constant space solution?

//Example 1:
//Input: matrix = [[1,1,1],
//                 [1,0,1],
//                 [1,1,1]]
//Output: [[1,0,1],
//         [0,0,0],
//         [1,0,1]]
//
//Example 2:
//Input: matrix = [[0,1,2,0],
//                 [3,4,5,2],
//                 [1,3,1,5]]
//Output: [[0,0,0,0],
//         [0,4,5,0],
//         [0,3,1,0]]
//
//Constraints:
//
//    m == matrix.length
//    n == matrix[0].length
//    1 <= m, n <= 200
//    -231 <= matrix[i][j] <= 231 - 1


import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=1KnLIAvTxjQ
public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] input = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        
        setZeroes(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {

                if(j%9==0){
                    System.out.println();
                }
                System.out.print(input[i][j]);
            }



            }
        }

public static void setZeroesPrac(int[][] matrix) {

}
    
    
    
//Leetcode solution has the solution with video.
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Set<Integer> rowRec = new HashSet<Integer>();
        Set<Integer> columnRec = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowRec.add(i);
                    columnRec.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rowRec and cols sets, update the elements.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowRec.contains(i) || columnRec.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
