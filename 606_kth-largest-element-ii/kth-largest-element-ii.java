/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/kth-largest-element-ii
@Language: Java
@Datetime: 17-04-10 18:39
*/

class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        return qs(nums, 0, nums.length - 1, k - 1);
    }
    public int qs(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[end];
        }
        
        int k = partition(nums, start, end);
        if (k == target) {
            return nums[k];
        } else if (k < target) {
            return qs(nums, k + 1, end, target);
        } else {
            return qs(nums, start, k - 1, target);
        }
    } 
    public int partition(int[] nums, int start, int end) {
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
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        nums[start] = nums[right];
        nums[right] = pivot;
        return right;
    }
};