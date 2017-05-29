/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 17-04-30 16:06
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, 1);
                } else {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                }
            }
        }
        
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                res.add(node);
                queue.offer(node);
            }
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode temp = queue.poll();
            for (DirectedGraphNode can : temp.neighbors) {
                indegree.put(can, indegree.get(can) - 1);
                if (indegree.get(can) == 0) {
                   res.add(can);
                   queue.offer(can); 
                } 
            }
        }
        return res;
    }
}