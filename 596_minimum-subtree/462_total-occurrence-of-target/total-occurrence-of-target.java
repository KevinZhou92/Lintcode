/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 17-01-23 21:56
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A.length == 0 || A == null) {
            return 0;
        }
        
        int start = 0;
        int end = A.length - 1;
        int head = 0;
        int tail = 0;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else{
                start = mid;
            }   
        }
        
        if (A[start] == target) {
            head = start;
        } else if (A[end] == target) {
            head = end;
        }
        
        if(A[head] != target) {
            return 0;
        }
        
        start = 0;
        end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if (A[end] == target) {
            tail = end;
        } else if (A[start] == target) {
            tail = start;
        }
        
        if (head == tail) {
            return 1;
        }
            
        return tail - head + 1;
        
    }
}