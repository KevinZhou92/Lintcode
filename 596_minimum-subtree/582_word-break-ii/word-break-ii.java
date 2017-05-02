/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-break-ii
@Language: Java
@Datetime: 17-03-15 21:06
*/

public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                if (wordDict.contains(word)) {
                    isWord[i][j] = true;
                }
            }
        }
        
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isWord[i][j] && possible[j + 1]) {
                    possible[i] = true;
                }
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        search(isWord, possible, 0, s, path, results);
        return results;
    }
    private void search(boolean[][] isWord, boolean[] possible,int startIndex, String s, ArrayList<Integer> path, List<String> results) {
        if (!possible[startIndex]) {
            return;
        }
        
        if (startIndex == s.length()) {
            StringBuilder sb = new StringBuilder();
            int lastIndex = 0;
            for (int i = 0; i < path.size(); i++) {
                sb.append(s.substring(lastIndex, path.get(i)));
                if (i != path.size() - 1) sb.append(" ");
                lastIndex = path.get(i);
            }
            results.add(sb.toString());
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            if (!isWord[startIndex][i]) {
                continue;
            }
            path.add(i + 1);
            search(isWord, possible, i + 1, s,  path, results);
            path.remove(path.size() - 1);
        }
    }
}