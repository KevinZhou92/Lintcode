/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 17-02-05 06:13
*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
     
    private class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
     
    
    public int numIslands(boolean[][] grid) {
        if (grid == null) {
            return 0;
        }
        
        if (grid.length ==0 || grid[0].length == 0) {
            return 0;
        }
        
        int islands = 0; 
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j< grid[0].length; j++) {
                if (grid[i][j]) {
                    myBFS(new Coordinate(i, j), grid);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void myBFS(Coordinate current, boolean[][] grid) {
        int[] deltaX = {1, 0, -1, 0};
        int[] deltaY = {0, 1, 0, -1};
        
        Queue<Coordinate> node = new LinkedList<>();
        node.offer(current);
        grid[current.x][current.y] = false;
        
        while(!node.isEmpty()) {
            Coordinate pos = node.poll();
            for (int i = 0; i < 4; i++) {
                int x = pos.x + deltaX[i];
                int y = pos.y + deltaY[i];
                if (!inBound(x, y, grid)) {
                    continue;
                } else if (grid[x][y]) {
                    grid[x][y] = false;
                    node.offer(new Coordinate(x, y));
                }
            }
        }
    }
    
    private boolean inBound(int x, int y, boolean[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}