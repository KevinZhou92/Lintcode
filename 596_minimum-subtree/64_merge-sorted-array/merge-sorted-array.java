/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 17-01-24 03:53
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int i, int[] B, int j) {
       if (A == null || B == null) {
           return;
       }
       
       
        
        int index = i + j -1;
        int n = i - 1;
        int m = j - 1;
        
        while (n >= 0 && m >=0 ){
            if (A[n] < B[m]) {
                A[index--] = B[m--];
            }else{
                A[index--] = A[n--];
            }
        }
        
        while(n >= 0) {
            A[index--] = A[n--]; 
        }
        
        while(m >= 0) {
            A[index--] = B[m--]; 
        }
    }
}