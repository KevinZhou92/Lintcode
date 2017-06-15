/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/maximum-average-subarray
@Language: Java
@Datetime: 17-05-20 19:17
*/

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } 
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        
        double start = min;
        double end = max;
        
        while (end - start >= 1e-5) {
            double mid = start + (end - start) / 2;
            if (valid(nums, mid, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
    
    private boolean valid(int[] nums, double mid, int k) {
        double[] sum = new double[nums.length + 1];
        double min_diff = 0;
        sum[0] = 0;
        
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >=k && sum[i] - min_diff >= 0) {
                return true;
            }
            if (i >= k) {
                min_diff = Math.min(min_diff, sum[i - k + 1]);
            }
        }
        return false;
    }
}