/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/knight-shortest-path
@Language: Java
@Datetime: 17-02-12 19:40
*/

/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
       // grid[source.x][source.y] = true;
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current.x == destination.x && current.y == destination.y) {
                    return steps;
                }
                
                for (int j = 0; j < 8; j++) {
                    Point candidate = new Point(current.x + deltaX[j], current.y + deltaY[j]);
                    if (!inBound(candidate, grid)) {
                        continue;
                    }
                    queue.offer(candidate);
                    grid[candidate.x][candidate.y] = true;
                }
            }
            steps++;
        }
        return -1;
            
    }
    
    public boolean inBound(Point point, boolean[][] grid) {
        if (point.x <0 || point.x >= grid.length) {
            return false;
        }
        if (point.y <0 || point.y >= grid[0].length) {
            return false;
        }
        
        return grid[point.x][point.y] == false;
    }
}
