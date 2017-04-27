/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/search-graph-nodes
@Language: Java
@Datetime: 17-02-10 02:51
*/

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();
        q.offer(node);
        hash.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode candidate = q.poll();
            if (values.get(candidate) == target) {
                return candidate;
            }
            for (UndirectedGraphNode neighbor : candidate.neighbors) {
                if (!hash.contains(neighbor)) {
                    q.offer(neighbor);
                    hash.add(neighbor);
                }
            }
        }
    return null;
    }
}