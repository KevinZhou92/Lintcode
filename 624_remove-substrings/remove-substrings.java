/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/remove-substrings
@Language: Java
@Datetime: 17-04-26 13:01
*/

public class Solution {
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        Queue<String> queue =  new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        
        queue.offer(s);
        set.add(s);
        
        int min = s.length();
        
        while (!queue.isEmpty()) {
            s = queue.poll();
            for (String sub : dict) {
                int found = s.indexOf(sub);
                while (found != -1) {
                    String new_s = s.substring(0, found) + s.substring(found + sub.length(), s.length());
                    if (!set.contains(new_s)) {
                        if (new_s.length() < min) {
                            min = new_s.length();
                        }
                        queue.offer(new_s);
                        set.add(new_s);
                    }
                    found = s.indexOf(sub, found + 1);
                }
            }
        }
        return min;
    }
}