/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/string-permutation
@Language: Java
@Datetime: 17-03-02 01:05
*/

public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        int[] count = new int[1000];
        
        for (int i = 0; i < A.length(); i++) {
            count[(int)A.charAt(i)]++;
        }
        for (int i = 0; i < B.length(); i++) {
            count[(int)B.charAt(i)]--;
        }
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}