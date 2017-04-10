/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 17-03-15 21:21
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || s == null) {
            return true;
        } 
        
        int max = getMax(s, dict);
        
        boolean[] possible = new boolean[s.length() + 1];
        possible[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= i && j <= max; j++) {
                if (!possible[i - j]) {
                    continue;
                }
                String last = s.substring(i - j, i);
                if (dict.contains(last)) {
                    possible[i] = true;
                }
            }
        }
        return possible[s.length()];
    }
    private int getMax(String s, Set<String> dict) {
        int max = Integer.MIN_VALUE;
        for (String next: dict) {
            if (next.length() > max) {
                max = next.length();
            }
        }
        return max;
    }
}