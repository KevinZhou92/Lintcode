/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/move-zeroes
@Language: Java
@Datetime: 17-03-29 04:01
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        int index = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[index];
                nums[index++] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
    }
}