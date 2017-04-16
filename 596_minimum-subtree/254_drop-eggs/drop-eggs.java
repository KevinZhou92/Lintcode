/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Java
@Datetime: 17-01-24 00:25
*/

/**
 * 本代码由九章算法编辑提供。版权所有，转发请注明出处。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，Big Data 项目实战班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
 */

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        long ans = 0;
        for (int i = 1; ;++i) {
            ans += (long)i;
            while (ans >= n) {
                return i;
            }
        }
        
    }
}