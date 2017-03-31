/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-input-array-is-sorted
@Language: Java
@Datetime: 17-03-28 23:43
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 1) {
            return null;
        }
        int[] res = new int[2];
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int total = nums[start] + nums[end];
            if (total > target) {
                end--;
            } else if (total < target) {
                start++;
            } else {
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }
        }
        return null;
    }
}