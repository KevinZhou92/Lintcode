/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-greater-than-target
@Language: Java
@Datetime: 17-04-04 23:58
*/

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum <= target) {
                start++;
            } else {
                count += end - start;
                end--;
            }
        }
        return count;
    }
}