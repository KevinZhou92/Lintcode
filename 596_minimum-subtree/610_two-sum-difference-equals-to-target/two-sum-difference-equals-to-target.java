/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-difference-equals-to-target
@Language: Java
@Datetime: 17-04-05 23:44
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    private class Pair{
        int index, num;
        public Pair(int x, int y) {
            this.num = x;
            this.index = y;
        }
    }
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 1) {
            return null;
        } 
        if (target < 0) {
            target = - target;
        }
        
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i + 1);
        }
        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.num - b.num;
            }
        });
        
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == end) {
                end++;
            }
            while (end < nums.length && pairs[end].num - pairs[i].num < target) {
                end++;
            }
            if (end < nums.length && pairs[end].num - pairs[i].num == target) {
                int[] res = new int[2];
                if (pairs[i].index > pairs[end].index) {
                    res[0] = pairs[end].index;
                    res[1] = pairs[i].index;
                    
                } else {
                    res[0] = pairs[i].index;
                    res[1] = pairs[end].index;
                }
                return res;
            }
        }
        return null;
    }
}