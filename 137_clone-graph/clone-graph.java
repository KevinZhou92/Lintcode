/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 17-02-17 16:22
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
        // write your code here
        if (node == null) {
            return null;
        }
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode candidate = nodes.get(i);
            for (UndirectedGraphNode neighbor : candidate.neighbors) {
                if (map.containsKey(neighbor)) {
                    continue;
                }
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                nodes.add(neighbor);
            }
        }
        
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode candidate = nodes.get(i);
            for (UndirectedGraphNode neighbor : candidate.neighbors) {
                map.get(candidate).neighbors.add(map.get(neighbor));
            }
        }
         return map.get(node);
    }
    
   
}