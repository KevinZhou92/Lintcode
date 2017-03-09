/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/maximum-average-subarray
@Language: Java
@Datetime: 17-01-31 01:30
*/

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
       if (nums.length == 0 || nums == null) {
           return 0;
       }
       
       double left = Integer.MAX_VALUE;
       double right = Integer.MIN_VALUE;
       
       for (int i = 0; i < nums.length; i++) {
           if (nums[i] > right) {
               right = nums[i];
           }
           if (nums[i] < left) {
               left = nums[i];
           }
       }
       
       
       double start = left;
       double end = right;
       double[] sum = new double[nums.length + 1];
       while (end - start >= 1e-6) {
           double average = (end + start) / 2.0;
           boolean check = false;
           double min_diff = 0;
           sum[0] = 0;
           for (int i = 1; i <= nums.length; i++) {
               sum[i] = sum[i - 1] + nums[i - 1] - average;
               if (i >= k && sum[i] >= min_diff) {
                   check = true;
                   break;
               }
               
               if (i >= k) {
                   min_diff = Math.min(min_diff, sum[i - k + 1]);//下一次循环i++了,所以此处是i+1
               }
            }
            if (check) {
               start = average;
            }else {
                end = average;
            }
       }
       return start;
       
    }
}