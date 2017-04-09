/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 17-02-17 01:58
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
        if (graph == null) {
            return null;
        }
        int size = graph.size();
        int[] indegree = new int[size];
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        
        for (int i = 0; i < size; i ++) {
            DirectedGraphNode node = graph.get(i);
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree[neighbor.label]++;
            }
        }
        
        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                order.add(graph.get(i));
            }
        }
        
        for (int i = 0; i < order.size(); i++) {
            DirectedGraphNode current = order.get(i);
            for (DirectedGraphNode neighbor : current.neighbors) {
                indegree[neighbor.label]--;
                if (indegree[neighbor.label] == 0) {
                    order.add(neighbor);
                }
            }
        }
        
        return order;
    }
}