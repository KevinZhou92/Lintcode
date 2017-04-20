/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-closest-to-target
@Language: Java
@Datetime: 17-03-30 03:36
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return target;
        }
        
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                diff = Math.min(Math.abs(nums[start] + nums[end] - target), diff);
                start++;
            } else if (nums[start] + nums[end] > target) {
                diff = Math.min(Math.abs(nums[start] + nums[end] - target), diff);
                end--;
            } else {
                diff = 0;
                return diff;
            }
        }
        return diff;
    }
}