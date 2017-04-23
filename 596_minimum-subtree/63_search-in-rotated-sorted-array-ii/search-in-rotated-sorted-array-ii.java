/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 17-01-24 01:17
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if (A.length == 0 || A == null) {
            return false;
        }
        
        for (int i = 0; i < A.length; i++){
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
