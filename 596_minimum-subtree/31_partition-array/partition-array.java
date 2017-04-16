/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 17-04-04 01:19
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    return partition(nums, 0, nums.length - 1, k);
    }
    private int partition(int[] nums, int start, int end, int target) {
        while(start <= end) {
            while (start <= end && nums[start] < target) {
                start++;
            }
            while (start <= end && nums[end] >= target) {
                end--;
            }
            if (start > end) {
                break;
            }
            exchange(nums, start, end);
        }
        
        if (start == nums.length - 1) {
            return nums.length;
        } 
        return start;
    }
    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}