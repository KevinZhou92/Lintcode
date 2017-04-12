/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 17-01-22 20:20
*/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums == null) {
            return -1;
        }
    
       int start = 0;
       int end = nums.length - 1;
       int target = nums[nums.length - 1];
       
        while (start + 1 < end) {
           int mid = start + (end - start) / 2;
           if (target >= nums[mid]) {
               end = mid;
           }else {
               start = mid;
           }
        }

        if (nums[start] < target) {
            return nums[start];
        }
        
        return nums[end];
       
    }
}