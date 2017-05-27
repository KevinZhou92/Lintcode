/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 17-05-01 14:45
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        int last = 1; 
        int lastlast = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = last + lastlast;
            lastlast = last;
            last = cur;
        }
        
        return cur;
    }
}