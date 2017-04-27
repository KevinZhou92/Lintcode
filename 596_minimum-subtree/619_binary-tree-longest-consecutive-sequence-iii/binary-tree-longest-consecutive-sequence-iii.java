/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-iii
@Language: Java
@Datetime: 17-02-06 04:41
*/

/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
     
    private class Result {
        int up, down, max;
        public Result(int up, int down, int max) {
            this.up = up;
            this.down = down;
            this.max = max;
        }
    } 
    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).max;
    }
    
    private Result helper(MultiTreeNode root) {
        if (root == null) {
            return new Result(0, 0, 0);
        }
        
        int up = 0, down = 0, max = 1;
        for (MultiTreeNode child : root.children) {
            Result node = helper(child);
            if (root.val == child.val + 1) {
                up = Math.max(up, node.up + 1);
            }
            if (root.val == child.val - 1) {
                down = Math.max(down, node.down + 1);
            }
            max = Math.max(max, node.max);
        }
         max = Math.max(up + down + 1, max);
        
        return new Result(up, down ,max);
    }
}