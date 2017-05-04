/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-unique-pairs
@Language: Java
@Datetime: 17-03-30 02:16
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int cnt = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                 start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                if (!map.containsKey(nums[start])) {
                    map.put(nums[start], nums[end]);
                    cnt++;
                    start++;
                    end--;
                } else {
                    start++;
                    end--;
                }
            }
        }
        return cnt;
    }
}