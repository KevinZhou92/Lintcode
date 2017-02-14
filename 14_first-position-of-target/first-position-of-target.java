/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 17-01-29 03:08
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            }else if (target > nums[mid]) {
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        
        if (target == nums[start]) {
            return start;
        }
        
        //if (target == nums[end]) {
       //     return end;
       // }
        return -1;
    }
}