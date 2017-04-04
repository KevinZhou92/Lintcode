/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 17-03-30 23:18
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int red = 0, blue = nums.length - 1;
        int i = 0;
        while (i <= blue) {
            if (nums[i] == 0) {
                int temp = nums[red];
                nums[red++] = 0;
                nums[i] = temp;
                i++;
            } else if(nums[i] == 2) {
                int temp = nums[blue];
                nums[blue--] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
    }
}