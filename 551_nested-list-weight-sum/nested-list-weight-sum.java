/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/nested-list-weight-sum
@Language: Java
@Datetime: 17-04-09 23:35
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
         if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger cur : nestedList) {
            queue.offer(cur);
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    sum += cur.getInteger() * depth;
                } else {
                    for (NestedInteger tmp : cur.getList()) {
                        queue.offer(tmp);
                    }
                }
            }
        }
        return sum;
    }
}