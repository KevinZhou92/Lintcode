/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/build-post-office-ii
@Language: Java
@Datetime: 17-02-25 00:19
*/

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
     
    private final int EMPTY = 0;
    private final int HOUSE = 1;
    private final int WALL = 2;
    private int n, m;
    private int[][] grid;
    
    private void setGrid(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
    }
    
    private class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null) {
            return -1;
        }
        
        setGrid(grid);
        List<Point> houses = new ArrayList<>();
        List<Point> empties = new ArrayList<>();
        
        houses = getPoints(HOUSE);
        empties = getPoints(EMPTY);
        
        int[][] visitedCount = new int[n][m];
        int[][] dis = new int[n][m];
        
        for (Point house : houses) {
            bfs(house, dis, visitedCount);
        }
        
        int shortest = Integer.MAX_VALUE;
        for (Point empty : empties) {
            if (visitedCount[empty.x][empty.y] != houses.size()) {
                continue;
            }
            shortest = Math.min(shortest, dis[empty.x][empty.y]);
        }
        
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
    
    
    private void bfs(Point empty, int[][] dis, int[][] visitedCount) {
        int[] deltaX = {-1, 1, 0, 0};
        int[] deltaY = {0, 0, 1, -1};
        
        Queue<Point> queue = new LinkedList<>();
        boolean[][] marked = new boolean[n][m];
        
        queue.offer(empty);
        marked[empty.x][empty.y] = true;
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = current.x + deltaX[j];
                    int y = current.y + deltaY[j];
                    if (!inBound(x, y) || marked[x][y]) {
                        continue;
                    }
                    visitedCount[x][y]++;
                    dis[x][y] += depth;
                    marked[x][y] = true;
                    queue.offer(new Point(x, y));
                }
            }
        }
    }
    
    private boolean inBound(int x, int y) {
        if (x < 0 || x > n - 1) {
            return false;
        }
        if (y < 0 || y > m - 1) {
            return false;
        }
        return grid[x][y] == EMPTY;
    } 
    
    
    
    private List<Point> getPoints(int type) {
        List<Point> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    result.add(new Point(i, j));
                }
            }
        }
        return result;
    }
}