/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix
@Language: Java
@Datetime: 17-05-24 04:41
*/

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
     
    private class Result {
        int pos;
        boolean exist;
        public Result(int pos, boolean exist) {
            this.pos = pos;
            this.exist = exist;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        
        int l = matrix[0][0];
        int r = matrix[n - 1][m - 1];
        
        while ( l + 1 < r) {
            int mid = l + (r - l) / 2;
            Result res = search(mid, matrix);
            if (res.pos == k && res.exist) {
                return mid;
            } else if (res.pos < k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
    private Result search(int mid, int[][]matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int pos = 0;
        
        boolean exist = false;
        int i = n - 1;
        int j = 0;
        while ( i >= 0 && j < m) {
            if (matrix[i][j] == mid) {
                exist = true;
            }
            if (matrix[i][j] <= mid) {
                pos += i + 1;
                j += 1;
            } else {
                i-= 1;
            }
        }
        return new Result(pos, exist);
    }
}