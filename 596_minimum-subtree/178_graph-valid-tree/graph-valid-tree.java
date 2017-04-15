/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Java
@Datetime: 17-02-14 21:04
*/

public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n < 0 || edges.length != n - 1) {
            return false;
        }
        
        
        
        Map<Integer, Set<Integer>> path = new HashMap<>();
        for (int i =0; i < n; i++) {
            path.put(i, new HashSet<Integer>());
        }
        for (int i = 0;i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            path.get(v).add(w);
            path.get(w).add(v);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int candidate = queue.poll();
            for (Integer x : path.get(candidate)) {
                if (visited.contains(x)) {
                    continue;
                }
                queue.offer(x);
                visited.add(candidate);
            }
        }
        
        return (count == n);
    }
}