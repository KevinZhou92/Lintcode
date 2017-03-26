/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 17-03-17 13:12
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        
        if (nums == null) {
            return result;
        }
        
        
        int[] suffix = new int[nums.length + 1];
        suffix[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            suffix[i] = suffix[i - 1] + nums[i - 1];
        }
        
        
        for (int i = 0; i <= nums.length; i++) {
            for (int j = nums.length; j > i; j--) {
                if (suffix[i] == suffix[j]) {
                    result.add(i);
                    result.add(j - 1);
                    return result;
                }
            }
        }
        return result;
    }
}