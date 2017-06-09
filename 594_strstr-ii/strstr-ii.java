/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/strstr-ii
@Language: Java
@Datetime: 17-04-12 04:37
*/

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    private int HASH_SIZE = 10000;
    
    public int hash_code(String input) {
        int hash_value = 0;
        for(int i = 0; i < input.length(); i++) {
            hash_value = ((hash_value * 33) % HASH_SIZE + input.charAt(i)) % HASH_SIZE;
        }
        return hash_value;
    }
    public int strStr2(String source, String target) {
        // Write your code here
        if(target == null) {
            return -1;
        }
        int m = target.length();
        if(m == 0) {
            return 0;
        }
        
        if(source == null) {
            return -1;
        }
        int n = source.length();
        if(n == 0) {
            return -1;
        }
        
        int input_hash = hash_code(target);
        
        int factor = 1;
        for (int i = 0; i < target.length(); i++) {
            factor = (factor * 33) % HASH_SIZE;
        }
        
        int temp = 0;
        int i = 0;
       
        for (i = 0; i < source.length(); i++) {
            temp = ((temp * 33) % HASH_SIZE + source.charAt(i)) % HASH_SIZE;
            
            if (i >= target.length()) {
                temp = temp - factor * source.charAt(i - target.length()) % HASH_SIZE;
                if (temp < 0) {
                    temp += HASH_SIZE;
                }
            }

            if (i >= m - 1 && temp == input_hash) {
                if (source.substring( i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}