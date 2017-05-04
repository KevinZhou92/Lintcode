/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sqrtx-ii
@Language: Java
@Datetime: 17-01-28 20:46
*/

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        double start = 0;
        double end = x > 1 ? x : 1;
        while (end - start >= 1e-10) {
            double mid = start + (end - start) / 2.0;
            
            if (mid * mid < x) {
                start = mid;
            }else if(mid * mid == x) {
                return mid;
            }else {
                end = mid;
            }
        } 
        
        if (start * start <= x) {
                return start;
            }
        return end;
    }
}