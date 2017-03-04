/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/maximum-number-in-mountain-sequence
@Language: Java
@Datetime: 17-01-25 20:16
*/

public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums.length == 0 || nums ==null) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }else {
                start = mid;
            }
  
        }
        if (nums[start] > nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}