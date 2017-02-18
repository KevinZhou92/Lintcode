/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/connected-component-in-undirected-graph
@Language: Java
@Datetime: 17-02-18 17:49
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    // Union-Find
    private class UF {
         HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        // construct the reflection between every node and its father
        public UF(ArrayList<UndirectedGraphNode> nodes) {
            for (UndirectedGraphNode node : nodes) {
                father.put(node.label, node.label);
                for (UndirectedGraphNode neighbor :  node.neighbors) {
                    father.put(neighbor.label, neighbor.label);
                }
            }
        }
        
        public int find (int x) {
            int fa = father.get(x);
            while (fa != father.get(fa)) {
                fa = father.get(fa);
            }
            return fa;
        }
        //more efficient find method
        public int compress_find(int x) {
            int fa = father.get(x);
            while (fa != father.get(fa)) {
                fa = father.get(fa);
            }
            
            int next;
            while(father.get(x) != x){
                next = father.get(x)
                father.put(x, fa);
                x = next;
            }
            return fa;
        }
        
        public void union(int x, int y) {
            int xfa = find(x);
            int yfa = find(y);
            if (xfa != yfa) {
                father.put(yfa, xfa);
            }
        }
    }
    // main solution
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> results =  new ArrayList<>();
        if (nodes == null) {
            return results;
        }
        // union-find
        UF uf = new UF(nodes);
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor :  node.neighbors) {
                if (uf.compress_find(neighbor.label) != uf.compress_find(node.label)) {
                    uf.union(node.label, neighbor.label);
                }
            }
        }
        // construct the result
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int node : uf.father.keySet()) {
            int fa = uf.find(node);
            if (!map.containsKey(fa)) {
                map.put(fa, new ArrayList<Integer>());
            }
            map.get(fa).add(node);
        }
        //sort the result
        for (List<Integer> result : map.values()) {
            Collections.sort(result);
            results.add(result);
        }
        
        return results;
    }
}
