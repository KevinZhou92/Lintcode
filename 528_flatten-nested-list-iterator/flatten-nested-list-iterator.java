/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/flatten-nested-list-iterator
@Language: Java
@Datetime: 17-05-12 14:20
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
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    
    private void pushto(List<NestedInteger> list) {
        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger tmp : list) {
            temp.push(tmp);
        }
        
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<>();
        pushto(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushto(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */