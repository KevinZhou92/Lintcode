/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 17-01-17 03:52
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
       
        if (source == null || target == null) return -1;
        if (target.equals("")) return 0;
        
       
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) != source.charAt(i+j)) {
                    break;
                }else if ( j == target.length()-1) {
                     return i;
                }
            }
        } 
        return -1;
    }
    
}