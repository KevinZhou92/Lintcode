/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 17-04-08 03:16
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        
        if (nums == null) {
            return new int[0];
        }
        
        for (int end = nums.length - 2; end >= 0; end--) {
            if (nums[end + 1] > nums[end]) {
                for (int j = nums.length - 1; j > end; j--) {
                    if (nums[j] > nums[end]) {
                        swap(nums, end, j);
                        break;
                    }
                }
                 reverse(nums, end + 1, nums.length - 1);
                 return nums;
            }
        }
        reverse(nums, 0, nums.length - 1);
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        for (;start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}