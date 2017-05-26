/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Java
@Datetime: 17-05-03 01:21
*/

public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        res.add(String.valueOf(chars));
        while ((chars = next(chars)) != null) {
            res.add(new String(chars));
        }
        return res;
    }
    private char[] next(char[] chars) {
        int index = -1;
        for (int i = chars.length - 1; i >=1; i--) {
            if (chars[i - 1] < chars[i]) {
                index = i -1;
                break;
            }
        }
        if (index == - 1) {
            return null;
        } 
        
        for (int j = chars.length - 1; j > index; j--) {
            if (chars[j] > chars[index]) {
                char tmp = chars[index];
                chars[index] = chars[j];
                chars[j] = tmp;
                break;
            }    
        }
        reverse(chars, index + 1, chars.length - 1);
        return chars;
    }
    public void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}