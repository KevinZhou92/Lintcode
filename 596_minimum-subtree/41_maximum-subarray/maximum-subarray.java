/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 17-03-19 05:36
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        
        return max;
    }
}