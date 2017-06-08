/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/previous-permutation
@Language: Java
@Datetime: 17-05-02 15:56
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		int len = nums.size();
		if ( len <= 1)
			return nums;
			
		for (int end = nums.size() - 2; end >= 0; end--) {
		    if (nums.get(end + 1) < nums.get(end)) {
		        for (int j = nums.size() - 1; j > end; j--) {
		            if (nums.get(j) < nums.get(end)) {
		                swap(nums, end, j);
		                break;
		            }
		        }
    		    reverse(nums, end + 1, nums.size() - 1);
    		    return nums;
    		}
		}
		reverse(nums, 0, nums.size() - 1);
		return nums;
    }
    
    private void swap(ArrayList<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
}
