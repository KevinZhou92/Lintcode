/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/implement-queue-by-two-stacks
@Language: Java
@Datetime: 17-05-01 20:40
*/

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
       // do initialization if necessary
       stack1 = new Stack();
       stack2 = new Stack();
    }
    
    public void push(int element) {
        // write your code here
        switchstack(stack1, stack2);
        stack2.push(element);
        switchstack(stack2,stack1);
    }

    public int pop() {
        // write your code here
        if (stack1.size() >= 1) {
            return stack1.pop();
        } else {
            return -1;
        }
    }

    public int top() {
        // write your code here
        if (stack1.size() >= 1) {
            return stack1.peek();
        } else {
            return -1;
        }
    }
    
    public void switchstack(Stack<Integer> s1, Stack<Integer> s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
    }
}