/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/window-sum
@Language: Java
@Datetime: 17-03-29 01:52
*/

public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums.length == 0 ) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                res[i] += nums[j]; 
            }
        }
        return res;
    }
}

