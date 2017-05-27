/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 17-05-02 20:06
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }
        
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        visited.add(start);
        queue.offer(start);
        
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String temp : neighbors(cur, dict)) {
                    if (!visited.contains(temp)) {
                        queue.offer(temp);
                        visited.add(temp);
                    }
                    if (temp.equals(end)) {
                        return depth;
                    }
                }
            } 
        }
        return 0;
    }
    
    private ArrayList<String> neighbors(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (s.charAt(i) != c) {
                    String newStr = replace(s, i , c);
                    if (dict.contains(newStr)) {
                        res.add(newStr);
                    }
                }
            }
        }
        return res;
    }
    private String replace(String s, int i, char c) {
        char[] characters = s.toCharArray();
        characters[i] = c;
        return new String(characters);
    }
}