/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/smallest-rectangle-enclosing-black-pixels
@Language: Java
@Datetime: 17-03-08 19:29
*/

public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        int n = image.length;
        int m = image[0].length;
        int left, right, up, bot;
        
        int start = 0;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (checkCol(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (checkCol(image, start)) {
            bot = start;
        } else {
            bot = end;
        }
        
        
        start = x;
        end = n -1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (checkCol(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (checkCol(image, end)) {
            up = end;
        } else {
            up = start;
        }
        
        start = 0;
        end = y;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (checkRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (checkRow(image, start)) {
            left = start;
        } else {
            left = end;
        }
        
        start = y ;
        end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (checkRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (checkRow(image, end)) {
            right = end;
        } else {
            right = start;
        }
        
        return (up - bot + 1) * (right - left + 1);
    }
    
    private boolean checkCol(char[][] image, int candidatePos) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[candidatePos][i] == '1') {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkRow(char[][] image, int candidatePos) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][candidatePos] == '1') {
                return true;
            }
        }
        return false;
    }
    
}