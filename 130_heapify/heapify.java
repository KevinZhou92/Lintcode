/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Java
@Datetime: 17-04-25 02:50
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
     
     private void swim(int[] A, int i) {
        while (i >= 0) {
            int father = (i - 1) / 2;
            if (A[father] <= A[i]) {
                break;
            }
             
            int temp = A[father];
            A[father] = A[i];
            A[i] = temp;
             
            i = father;
         }
     }
    public void heapify(int[] A) {
        // write your code here
        for (int i = 0; i < A.length; i++) {
            swim(A, i);
        }
    }
}