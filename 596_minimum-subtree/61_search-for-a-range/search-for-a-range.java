/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 17-01-28 23:27
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1,-1};

        if (A == null || A.length == 0) {
            return result; 
        }
        
        int pos1,pos2;
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            }else {
                start = mid;
            }
        }
         if (A[start] == target) {
                pos1 = start;
            } else if (A[end] == target) {
                pos1 = end;
            } else {
                pos1 = -1;
            }
        
        start = 0;
        end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            }else {
                start = mid;
            }
        }
        if (A[end] == target) {
                pos2 = end;
            } else if (A[start] == target) {
                pos2 = start;
            } else {
                pos2 = -1;
            }
            
        result[0] = pos1;
        result[1] = pos2;
        return result;
    }
}
