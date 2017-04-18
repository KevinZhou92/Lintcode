/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Java
@Datetime: 17-01-28 03:19
*/

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || k > A.length) {
            return null;
        }
        
        
        int[] results = new int[k];
        int index = firstIndex(A, target);
        int pos1 = index - 1;
        int pos2 = index;
        int count = 0;
        
        while (pos1 >=0 && pos2 < A.length && count < k ) {
            if (Math.abs(target - A[pos1]) <= Math.abs(target - A[pos2])) {
                results[count++] = A[pos1--];
            }else {
                results[count++] = A[pos2++];
            }
        }
        
        while (pos1 >= 0 && count < k) {
            results[count++] = A[pos1--];
        }
        
        while (pos2 < A.length && count < k) {
            results[count++] = A[pos2++];
        }
        return results;
        
    }
    
    private int firstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if (A[start] >= target ){
            return start;
        }
        return end;
    }
}