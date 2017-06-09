/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/zigzag-iterator-ii
@Language: Java
@Datetime: 17-04-24 02:19
*/

public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
     
    ArrayList<Iterator<Integer>> iterators;
    int turn;
    int size;
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        turn = 0;
        iterators = new ArrayList<>();
        for (ArrayList<Integer> vec : vecs) {
            if (vec.size() != 0) {
                iterators.add(vec.iterator());
            }
        }
        size = iterators.size();
    }

    public int next() {
        // Write your code here
        turn = turn % iterators.size();
        Iterator<Integer> cur = iterators.get(turn); 
        int res = cur.next();
        if (!cur.hasNext()) {
            iterators.remove(turn);
            turn -= 1;
        }
        turn++;
        return res;
    }

    public boolean hasNext() {
        // Write your code here
        return iterators.size() != 0;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */