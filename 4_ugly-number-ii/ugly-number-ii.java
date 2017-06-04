/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 17-04-12 01:38
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int last = ugly.get(ugly.size() - 1);
            
            while (ugly.get(p1) * 2 <= last) p1++;
            while (ugly.get(p2) * 3 <= last) p2++;
            while (ugly.get(p3) * 5 <= last) p3++;
            
            ugly.add(Math.min(
                Math.min(ugly.get(p1) * 2, ugly.get(p2) * 3),
                ugly.get(p3) * 5
            ));
        }
        return ugly.get(ugly.size() - 1);
    }
};
