/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 17-04-10 01:12
*/

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    private class Point {
        int row, col, val;
        public Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    private Comparator<Point> com = new Comparator<Point>() {
        public int compare(Point left, Point right) {
            return left.val - right.val;
        }
    };
    
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if (arrays.length == 0) {
            return new ArrayList<>();
        }
        
        Queue<Point> pq = new PriorityQueue<Point>(arrays.length, com);
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 0) {
                pq.offer(new Point(i, 0, arrays[i][0]));
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            res.add(cur.val);
            if (cur.col + 1 < arrays[cur.row].length) {
                cur.col += 1;
                cur.val = arrays[cur.row][cur.col];
                pq.add(cur);
            }
        }
        
        return res;
    }
}