/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Java
@Datetime: 17-01-28 22:36
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        int count = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return count;
        }
        
        
        int x = 0;
        int y = matrix[0].length - 1;
        
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] < target) {
                x++;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                count++;
                x++;
                y--;
            }
        }
        
        return count;
    }
}
