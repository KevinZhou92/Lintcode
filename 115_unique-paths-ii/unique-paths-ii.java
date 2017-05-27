/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 17-04-28 05:00
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < obstacleGrid.length; j++) {
                    dp[j][0] = 0;
                }
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < obstacleGrid[0].length; j++) {
                    dp[0][j] = 0;
                }
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}