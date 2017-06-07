/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Java
@Datetime: 17-04-10 04:07
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return qs(nums, 0, nums.length - 1, k - 1);
    }
    private int qs(int[] nums, int start, int end, int target) {
        if (end == start) {
            return nums[end];
        }
        
        int k = partition(nums, start, end);
        if ( k == target) {
            return nums[k];
        } else if (k < target) {
            return qs(nums, k + 1, end, target);
        } else {
            return qs(nums, start, k - 1, target);
        }
    }
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                exchange(nums, left, right);
                left++;
                right--;
            }
        }
        exchange(nums, start, right);
        return right;
    }
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};