/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 17-03-14 06:32
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
       List<List<String>> results = new ArrayList<>();
       if (dict == null) {
           return results;
       }
       
       dict.add(start);
       dict.add(end);
       
       Map<String, List<String>> map = new HashMap<>();
       Map<String, Integer> dist = new HashMap<>();
       
       bfs(map, dist, start, end, dict);
       List<String> path = new ArrayList<>();
       dfs(map, dist, start, end, path, results);
       
       return results;
    }
    
    private void dfs(Map<String, List<String>> map, Map<String, Integer> dist, String start, String end, List<String> path, List<List<String>> results) {
        
        path.add(end);
        if (end.equals(start)) {
            Collections.reverse(path);
            results.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else{
            for (String next : map.get(end)) {
                if (dist.get(next) == dist.get(end) - 1 ) {
                    dfs(map, dist, start, next, path, results);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
    private void bfs(Map<String, List<String>> map, Map<String, Integer> dist, String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        queue.offer(start);
        dist.put(start, 0);
        
        while(!queue.isEmpty()) {
            String current = queue.poll();
            for (String next : expand(current, dict)) {
                map.get(current).add(next);
                if (!dist.containsKey(next)) {
                    dist.put(next, dist.get(current) + 1);
                    queue.offer(next);
                }
            }
        }
    }
    
    private List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
}