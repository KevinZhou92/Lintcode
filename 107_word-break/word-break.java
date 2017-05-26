/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 17-05-03 16:16
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here 
        if (s == null || s.length() == 0) {
            return true;
        } 
        int max = Integer.MIN_VALUE;
        for (String x : dict) {
            max = Math.max(x.length(), max);
        }
        
        boolean[] available = new boolean[s.length() + 1];
        available[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int last = 1; last <= i && last <= max; last++) {
                if (!available[i - last]) {
                    continue;
                }
                String sub = s.substring(i - last, i);
                if (dict.contains(sub)) {
                    available[i] = true;
                }
            }
        }
        return available[s.length()];
    }
}