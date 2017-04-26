/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 17-01-25 20:19
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] || A[mid] < A[mid + 1]) {
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if (A[end] > A[start]) {
            return end;
        }
        return start;
    }
}