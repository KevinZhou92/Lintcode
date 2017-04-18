/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/recover-rotated-sorted-array
@Language: Java
@Datetime: 17-01-28 21:35
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                rotate(nums, 0, index);
                rotate(nums, index + 1, nums.size() - 1);
                rotate(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
    
    public void rotate(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end;i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}