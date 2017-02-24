/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 17-02-15 19:59
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        ArrayList<UndirectedGraphNode> nodes = getNode(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        //copy nodes
        for (UndirectedGraphNode x : nodes) {
            map.put(x, new UndirectedGraphNode(x.label));
        }
        
        for (UndirectedGraphNode x: nodes) {
            UndirectedGraphNode newNode = map.get(x);
            for (UndirectedGraphNode candidate : x.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(candidate);
                newNode.neighbors.add(newNeighbor);
            }
        }
        
        return map.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNode(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        nodes.add(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode candidate = queue.poll();
            for (UndirectedGraphNode x : candidate.neighbors) {
                if (!visited.contains(x)) {
                    nodes.add(x);
                    queue.offer(x);
                    visited.add(x);
                }
            }
        } 
        
        return nodes;
    }
}