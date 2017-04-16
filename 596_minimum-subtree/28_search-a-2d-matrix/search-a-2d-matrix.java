/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 17-01-28 22:48
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            int start = 0; 
            int end = matrix[0].length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] > target) {
                    end = mid;
                } else if (matrix[i][mid] < target) {
                    start = mid;
                } else {
                    return true;
                }
            }
            if (matrix[i][start] == target) {
                return true;
            }
            if (matrix[i][end] == target) {
                return true;
            }
    }
        return false;
    }
}
