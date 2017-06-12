/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/expression-expand
@Language: Java
@Datetime: 17-04-22 00:57
*/

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        int number = 0;
        int parent = 0;
        String substring = "";
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '[') {
                if (parent > 0) {
                    substring += c;
                }
                parent++;
            } else if (c == ']') {
                parent--;
                if (parent == 0) {
                    String expand = expressionExpand(substring);
                    for (int i = 0; i < number; i++) {
                        sb.append(expand);
                    }
                    number = 0;
                    substring = "";
                } else {
                    substring += c;
                }
            } else if (Character.isDigit(c)) {
                if (parent == 0) {
                    number = number * 10 + c - '0';
                } else {
                    substring += c;
                }
            } else {
                if (parent == 0) {
                    sb.append(String.valueOf(c));
                } else {
                    substring += c;
                }
            }
        }
        return sb.toString();
    }
}