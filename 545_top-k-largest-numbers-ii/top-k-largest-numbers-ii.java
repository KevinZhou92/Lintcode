/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 17-04-11 03:09
*/

public class Solution {
    private Queue<Integer> pq;
    private int size;
    public Solution(int k) {
        // initialize your data structure here.
        pq = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
           public int compare(Integer a, Integer b) {
               return b - a;
           } 
        });
        size = k;
    }

    public void add(int num) {
        // Write your code here
        pq.add(num);
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
            if (res.size() == size) {
                break;
            }
        }
        
        for (int i : res) {
            pq.add(i);
        }
        return res;
    }
};