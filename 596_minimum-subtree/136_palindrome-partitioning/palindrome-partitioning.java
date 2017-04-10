/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 17-03-02 00:05
*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
       List<List<String>> results = new ArrayList<>();
       
       if (s == null) {
           return results;
       }
       
       List<String> path = new ArrayList<>();
       helper(results, path, 0, s);
       return results;
    }
    
    private void helper (List<List<String>> results, List<String> path, int startIndex, String s) {
        if (startIndex == s.length()) {
            results.add(new ArrayList(path));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            String partition = s.substring(startIndex, i + 1);
            if (!panlindrome(partition)) {
                continue;
            }
            path.add(partition);
            helper(results, path, i + 1, s);
            path.remove(path.size() - 1);
        }
    }
    
    private boolean panlindrome(String partition) {
        for(int i = 0, j = partition.length() - 1; i<=j; i++, j--) {
            if (partition.charAt(i) != partition.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}