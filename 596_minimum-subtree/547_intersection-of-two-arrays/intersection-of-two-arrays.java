/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 17-03-20 19:56
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }
        Set<Integer> result = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])){
                result.add(nums2[j]);
            }
        }
        int[] res = new int[result.size()];
        int index = 0;
        for (int i : result) {
            res[index++] = i;
        }
        return res;
    }
}