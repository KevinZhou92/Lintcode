/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/remove-duplicate-numbers-in-array
@Language: Java
@Datetime: 17-03-28 17:50
*/

public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int index = 0;
        for (int i : set) {
            nums[index++] = i;
        }
        return index ;
    }
}