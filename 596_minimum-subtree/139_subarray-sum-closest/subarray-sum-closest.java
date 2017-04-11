/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Java
@Datetime: 17-03-20 03:38
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     
    private class Pair {
        int sum;
        int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    } 
    
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null) {
            return new int[0];
        }
        int[] res = new int[2];
    
        Pair[] sum = new Pair[nums.length + 1];
        sum[0] = new Pair(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = new Pair(sum[i - 1].sum + nums[i - 1], i);
        }
        
        Arrays.sort(sum , new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (max > sum[i].sum - sum[i - 1].sum) {
                max = sum[i].sum - sum[i - 1].sum;
                int[] temp = new int[2];
                temp[0] = sum[i - 1].index;
                temp[1] = sum[i].index;
                Arrays.sort(temp);
                res[0] = temp[0];
                res[1] = temp[1] - 1;
            }
        }
        return res;
    }
   
}
