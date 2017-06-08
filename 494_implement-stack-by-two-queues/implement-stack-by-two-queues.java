/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/implement-stack-by-two-queues
@Language: Java
@Datetime: 17-04-11 20:04
*/

class Stack {
    // Push a new item into the stack
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    private void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    private void moveitems() {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
    }
    public Stack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    public void push(int x) {
        // Write your code here
        q1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        moveitems();
        q1.poll();
        swap();
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        moveitems();
        int x = q1.poll();
        swap();
        q1.offer(x);
        return x;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty();
    }    
}