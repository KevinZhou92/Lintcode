/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 17-04-04 01:59
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        quicksort(colors, 0, colors.length - 1, 1, k);
    }
    private void quicksort (int[] colors, int lo, int hi, int colorStart, int colorEnd) {
        if (hi <= lo) {
            return;
        }
        if (colorStart == colorEnd) {
            return;
        }
        int start = lo, end = hi;
        int mid = (colorStart + colorEnd)/2;
        while (lo <= hi) {
            while (lo <= hi && colors[lo] <= mid) {
                lo++;
            }
            while (lo <= hi && colors[hi] > mid) {
                hi--;
            }
            if (lo > hi) {
                break;
            }
            int tmp = colors[hi];
            colors[hi] = colors[lo];
            colors[lo] = tmp;
        }
        quicksort(colors, start, hi, colorStart, mid);
        quicksort(colors, lo, end, mid + 1, colorEnd);
    }
    
}