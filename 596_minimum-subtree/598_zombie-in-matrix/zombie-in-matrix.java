/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/zombie-in-matrix
@Language: Java
@Datetime: 17-02-14 03:51
*/

public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
     
    private class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};
        
        
        int days = 0;
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = deltaX[j] + current.x;
                    int y = deltaY[j] + current.y;
                    
                    if (!inBound(x, y, grid)) {
                        continue;
                    }
                    
                    grid[x][y] = 1;
                    queue.offer(new Point(x, y));
                    count--;
                }
            }
            days++;
            if (count == 0) {
                return days;
            }
        }
        
        return -1;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length) {
            return false;
        }
        if (y < 0 || y >= grid[0].length) {
            return false;
        }
        
        if (grid[x][y] == 1 || grid[x][y] == 2) {
            return false;
        }
        return true;
    }   
}