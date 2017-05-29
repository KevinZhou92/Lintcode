/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 17-04-25 14:14
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        
        int maxlength = 1;
        for (int i = 0; i < num.length; i++) {
            int up = num[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up += 1;
            }
            
            int down = num[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down -= 1;
            }
            
            maxlength = Math.max(maxlength, up - down - 1);
        }
        return maxlength;
    }
}