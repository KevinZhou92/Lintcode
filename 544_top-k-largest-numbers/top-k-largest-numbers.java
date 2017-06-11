/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 17-04-09 22:29
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        quicksort(nums, 0, nums.length - 1);
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            res[index++] = nums[i];
        }
        return res;
    }
    public void quicksort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int k = partition(nums, start, end);
        quicksort(nums, start, k -1);
        quicksort(nums, k + 1, end);
    }
    public int partition(int[] nums, int start, int end) {
        int lo = start;
        start = start + 1;
        while (start <= end) {
            while (start <= end && nums[start] < nums[lo]) {
                start++;
            }
            while (start <= end && nums[end] > nums[lo]) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                
                start++;
                end--;
            }
        }
        int temp = nums[end];
        nums[end] = nums[lo];
        nums[lo] = temp;
        return end;
    }
};

