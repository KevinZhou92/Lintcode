/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/climbing-stairs-ii
@Language: Java
@Datetime: 17-05-02 19:18
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <=3; j++) {
                if (i >=j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}