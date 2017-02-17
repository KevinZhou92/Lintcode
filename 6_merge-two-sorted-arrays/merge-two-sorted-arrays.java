/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 17-01-24 04:00
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
       if (A == null) {
           return B;
       }
       
       if (B == null) {
           return A;
       } 
       
       int[] merged = new int[A.length + B.length];
       
       int n = 0;
       int m = 0;
       int index = 0;
       
       while (n < A.length && m < B.length) {
           if(A[n] < B[m]) {
               merged[index++] = A[n++];
           }else {
               merged[index++] = B[m++];
           }
       }   
       while (n < A.length) {
           merged[index++] = A[n++];
       }
       
       while (m < B.length) {
           merged[index++] = B[m++];
       }
        return merged;   
    }
}
