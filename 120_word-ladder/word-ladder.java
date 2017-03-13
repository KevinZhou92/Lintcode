/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 17-02-25 17:22
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.length() != end.length()) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        
        int depth = 1;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : getWords(current, dict)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return depth;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return 0;
    }
    
    private ArrayList<String> getWords(String word, Set<String> dict) {
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String next =  replace(word, i, c);
                if (results.contains(next)) {
                    continue;
                }
                if (dict.contains(next)) {
                    results.add(next);
                }
            }
        }
        return results;
    }
    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        if (chars[index] != c) {
            chars[index] = c;
        }
        return new String(chars);
    }
}