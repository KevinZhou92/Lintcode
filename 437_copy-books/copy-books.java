/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/copy-books
@Language: Java
@Datetime: 17-01-28 19:59
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        
        int total = 0;
        int max = 0;
        
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] > max) {
                max = pages[i];
            }
            total += pages[i];
        }
        
        int start = max;
        int end = total;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countCopier(mid,pages) > k) {
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if (countCopier(start, pages) <= k) {
            return start;
        }
        return end;
        
    }
    
    
    private int countCopier(int time, int[] pages) {
        int copier = 1;
        int sum = pages[0];
        
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > time) {
                sum = 0;
                copier++;
            }
            sum = sum + pages[i];
        }
        return copier;
    }
}