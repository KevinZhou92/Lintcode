/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/permutation-index
@Language: Java
@Datetime: 17-03-02 16:36
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        long index = 0;
        for (int i = 0; i < A.length - 1; i++) {
            long possibility = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    possibility++;
                }
            }
            
            index += possibility;
            index *= (A.length - 1 - i);
        }
        return index + 1;
    }
}