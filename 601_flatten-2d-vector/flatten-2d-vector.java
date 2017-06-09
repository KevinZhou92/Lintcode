/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/flatten-2d-vector
@Language: Java
@Datetime: 17-04-15 19:22
*/

public class Vector2D implements Iterator<Integer> {
    Stack<List<Integer>> stack;
    Stack<Integer> list;
    
    private void pushlist(List<List<Integer>> vec2d) {
        Stack<List<Integer>> temp = new Stack<>();
        for (List<Integer> tem : vec2d) {
            temp.push(tem);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    
    private void pushint(List<Integer> cur) {
        Stack<Integer> tem = new Stack<>();
        for (Integer nested : cur) {
            tem.push(nested);
        }
        while (!tem.isEmpty()) {
            list.push(tem.pop());
        }
    }
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        stack = new Stack<>();
        list = new Stack<>();
        pushlist(vec2d);
    }

    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()){
            return null;
        }
        return list.pop();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (list.isEmpty()  && !stack.isEmpty()) {
            pushint(stack.pop());
        }
        return !list.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */