/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 17-01-28 20:31
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
     
        if (x < 0) {
            return -1;   
        }
        
        int start = 0;
        int end = x;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid; 
            }else if (mid == x / mid) {
                return mid;
            }else {
                end = mid;
            }
        }
        
        if (end == 0 || end == 1) {
            return (int)end;
        }
        
        return (int)start;
    }
}