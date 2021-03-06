/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sequence-reconstruction
@Language: Java
@Datetime: 17-04-30 04:55
*/

public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for (int num : org) {
            map.put(num, new HashSet<Integer>());
            indegree.put(num, 0);
        }
        
        int n = org.length;
        int count = 0;
        for (int[] seq : seqs) {
            count += seq.length;
            if (seq.length >=1 && (seq[0] <=0 || seq[0] > n)) {
                return false;
            }
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > n) {
                    return false;
                }
                if (map.get(seq[i - 1]).add(seq[i])) {
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }
        
        if (count < n) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int key : map.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }
        
        int cnt = 0;
        while (queue.size() == 1) {
            for (int next : map.get(queue.poll())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
            cnt++;
        }
        
        return cnt == org.length;
    }
}