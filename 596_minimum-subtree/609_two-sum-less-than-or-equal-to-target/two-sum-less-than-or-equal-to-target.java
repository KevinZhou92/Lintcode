/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target
@Language: Java
@Datetime: 17-03-28 22:00
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0] >= target ? 0 : nums[0];
        }   
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j;) {
            if (nums[i] + nums[j] <= target) {
                count += j - i;
                i++;
                
            } else {
                j--;
            }
        }
        return count;
    }
}