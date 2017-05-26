/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 17-05-06 15:04
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
   private int[][] minSum;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        minSum = new int[triangle.length][triangle.length];
        for (int i = triangle.length -1 ; i >= 0; i--) {
            for (int j = 0; j <=i ; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return  search(0, 0, triangle);
        
    }
    private int search(int x, int y, int[][] triangle) {
        if (x >= triangle.length) {
            return 0;
        }
        
        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }
        
        minSum[x][y] = Math.min(search(x + 1, y, triangle), search(x + 1, y + 1, triangle)) + triangle[x][y];
        return minSum[x][y];
    }
}
