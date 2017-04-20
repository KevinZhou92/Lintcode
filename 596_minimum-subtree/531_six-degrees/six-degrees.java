/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Java
@Datetime: 17-02-17 15:26
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        ArrayList<UndirectedGraphNode> nodes =  new ArrayList<>();
        nodes.add(s);
        
        
        if (s.equals(t)) {
            return 0;
        }
        
        int degree =0;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(s);
        nodes.add(s);
        
        while (!queue.isEmpty()) {
            degree++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    if (nodes.contains(neighbor)) {
                        continue;
                    }
                    if (neighbor.equals(t)) {
                        return degree; 
                    }
                    nodes.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        return -1;
    }
}