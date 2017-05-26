/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Java
@Datetime: 17-05-01 21:14
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
         
        int[][] sum = new int[grid.length][grid[0].length]; 
        
        sum[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            sum[i][0] = grid[i][0] + sum[i - 1][0]; 
        } 
        for (int i = 1; i < grid[0].length; i++) {
            sum[0][i] = grid[0][i] + sum[0][i - 1]; 
        } 
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                sum[i][j] = Math.min(sum[i - 1][j] + grid[i][j], sum[i][j - 1] + grid[i][j]);
            }
        }
        
        return sum[grid.length - 1][grid[0].length - 1];
    }
}
