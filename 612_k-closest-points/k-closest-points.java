/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/k-closest-points
@Language: Java
@Datetime: 17-04-08 23:24
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    private Point global_origin;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        global_origin = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDiff(b, global_origin) - getDiff(a, global_origin);
                if (diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });
        
        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        Point[] res = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll(); 
        }
        return res;
    }
    public int getDiff(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}