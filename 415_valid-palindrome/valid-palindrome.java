/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Java
@Datetime: 17-03-30 01:51
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s.length() == 0 || s == null) {
            return true;
        }
        
        s = s.toUpperCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if(valid(start, s)) {
                start++;
                continue;
            }
            if (valid(end, s)) {
                end--;
                continue;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
    private boolean valid(int start, String s) {
        return (s.charAt(start) < 'A' || s.charAt(start) > 'Z') && (s.charAt(start) < '0' || s.charAt(start) > '9');
    }
}