/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/kth-smallest-numbers-in-unsorted-array
@Language: Java
@Datetime: 17-04-07 23:30
*/

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null || k < 0 || k > nums.length) {
            return 0;
        }
        quicksort(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }
    private void quicksort(int[] nums, int lo, int hi, int target) {
        if (hi <= lo) {
            return;
        }
        
        int pos = partition(nums, lo, hi);
        if (pos < target) {
            quicksort(nums, pos + 1, nums.length - 1, target);
        } else if (pos > target) {
            quicksort(nums, lo, pos - 1, target);
        } else {
            return;
        }
    }
    public int partition(int[] nums, int lo, int hi) {
        
        int left = lo + 1;
        int right = hi;
        
        while (left <= right) {
            while (left <= right && nums[left] < nums[lo]) {
                left++;
            }
            while (left <= right && nums[right] > nums[lo]) {
                right--;
            }
            if(left <= right) {
                exchange(nums, left, right);
                left++;
                right--;
            }
        }
        exchange(nums, right, lo);
        return right;
    }
    public void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}