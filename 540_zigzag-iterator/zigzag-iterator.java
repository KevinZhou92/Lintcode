/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/zigzag-iterator
@Language: Java
@Datetime: 17-04-24 01:19
*/

public class ZigzagIterator {
    /**
     * @param v1 v2 two 1d vectors
     *
    */
    private Iterator<Integer> l1;
    private Iterator<Integer> l2;
    private int pos;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        l1 = v1.iterator();
        l2 = v2.iterator();
        pos = 0;
    }

    public int next() {
        // Write your code here
        if (!hasNext()) {
            return 0;
        }
        pos++;
        if (pos % 2 == 1 && l1.hasNext() || !l2.hasNext()) {
            return l1.next();
        }
        if (pos % 2 == 0 && l2.hasNext() || !l1.hasNext()) {
            return l2.next();
        }
        return 0;
    }

    public boolean hasNext() {
        // Write your code here  
        return l1.hasNext() || l2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */