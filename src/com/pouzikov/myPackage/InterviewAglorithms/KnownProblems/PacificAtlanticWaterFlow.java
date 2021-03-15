package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;
//Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean"
//touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges. Water can only
//flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower. Find the list
//of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
//
//Note:
//    The order of returned grid coordinates does not matter.
//    Both m and n are less than 150.


import java.util.*;

//Example:
//Given the following 5x5 matrix:
//
//  Pacific ~   ~   ~   ~   ~
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//
//Return:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
public class PacificAtlanticWaterFlow {
    public static PacificAtlanticWaterFlow bfs;
    public static void main(String[] args) {
      int[][] matrix = {
              {1,2,2,3,5},
              {3,2,3,4,4},
              {2,4,5,3,1},
              {6,7,1,4,5},
              {5,1,1,2,4}
      };

        printArr(bfs.pacificAtlantic(matrix));
    }

    public static void printArr(List<int[]> matrix){
        int count = 0;
        char letter = 'a';
        System.out.print(letter + ":");
        for(int[] i : matrix) {

            System.out.print(" {");

            for (int j : i) {

                count++;
                if(count % 2 == 0)
                    System.out.print(", ");
                System.out.print(j);

            }

letter++;
                System.out.print("} " + letter + ":");
//
        }
    }







//Faster than 99.99%
//______________________________________________________________________________________________________
    private static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        char[][] visited = new char[m][n];
        for (int col = 0; col < n; col++) {
            dfs(matrix, 0, col, visited, 'P', res);
        }
        for (int row = 0; row < m; row++) {
            dfs(matrix, row, 0, visited, 'P', res);
        }

        for (int col = 0; col < n; col++) {
            dfs(matrix, m - 1, col, visited, 'A', res);
        }
        for (int row = 0; row < m; row++) {
            dfs(matrix, row, n - 1, visited, 'A', res);
        }
        return res;
    }

    private static void dfs(int[][] matrix, int row, int col, char[][] visited, char ch, List<int[]> res) {
        if (visited[row][col] == 'P' && ch == 'A') res.add(new int[]{row, col});
        visited[row][col] = ch;
        for (int[] dir : directions) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[row][col] > matrix[x][y] || visited[x][y] == ch)
                continue;
            dfs(matrix, x, y, visited, ch, res);
        }

    }

//________________________________________________________________________________________
    public class BFSSolution {
        int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> res = new LinkedList<>();
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return res;
            }
            int n = matrix.length, m = matrix[0].length;
            //One visited map for each ocean
            boolean[][] pacific = new boolean[n][m];
            boolean[][] atlantic = new boolean[n][m];
            Queue<int[]> pQueue = new LinkedList<>();
            Queue<int[]> aQueue = new LinkedList<>();
            for(int i=0; i<n; i++){ //Vertical border
                pQueue.offer(new int[]{i, 0});
                aQueue.offer(new int[]{i, m-1});
                pacific[i][0] = true;
                atlantic[i][m-1] = true;
            }
            for(int i=0; i<m; i++){ //Horizontal border
                pQueue.offer(new int[]{0, i});
                aQueue.offer(new int[]{n-1, i});
                pacific[0][i] = true;
                atlantic[n-1][i] = true;
            }
            bfs(matrix, pQueue, pacific);
            bfs(matrix, aQueue, atlantic);
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(pacific[i][j] && atlantic[i][j])
                        res.add(new int[]{i,j});
                }
            }
            return res;
        }
        public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
            int n = matrix.length, m = matrix[0].length;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int[] d:dir){
                    int x = cur[0]+d[0];
                    int y = cur[1]+d[1];
                    if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                        continue;
                    }
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }


//__________________________________________________________________________________________________________________
    public class DFSSolution {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> res = new LinkedList<>();
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return res;
            }
            int n = matrix.length, m = matrix[0].length;
            boolean[][]pacific = new boolean[n][m];
            boolean[][]atlantic = new boolean[n][m];
            for(int i=0; i<n; i++){
                dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
                dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
            }
            for(int i=0; i<m; i++){
                dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
                dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (pacific[i][j] && atlantic[i][j])
                        res.add(new int[] {i, j});
            return res;
        }

        int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
            int n = matrix.length, m = matrix[0].length;
            if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
                return;
            visited[x][y] = true;
            for(int[]d:dir){
                dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
            }
        }
    }
}
