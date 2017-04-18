/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/classical-binary-search
@Language: Java
@Datetime: 17-01-22 23:09
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end =nums.length - 1;
        
        while (start + 1 < end) {
            int  mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            }else if(nums[mid] < target) {
                start = mid;
            }else {
                return mid;
            }
        }
         if (nums[start] == target) {
                return start;
            }
            
            if (nums[end] == target) {
                return end;
            }
            return -1;
    }
}