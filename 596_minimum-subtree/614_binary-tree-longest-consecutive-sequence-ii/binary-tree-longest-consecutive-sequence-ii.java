/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii
@Language: Java
@Datetime: 17-02-05 21:39
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
     
    private class Result{
        int up, down, max;
        public Result(int x, int y, int z) {
            this.up = x;
            this.down = y;
            this.max = z;
        }
    }
    public int longestConsecutive2(TreeNode root) {
        Result end = helper(root);
        return end.max;
    }
    
    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, 0, 0);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result result = new Result(1, 1, 1);
        
        if (root.left != null && root.left.val + 1 == root.val) {
            result.up = Math.max(left.up + 1, 1);
        }
        if (root.right != null && root.right.val + 1 == root.val) {
            result.up = Math.max(right.up + 1, result.up);
        }
        
        if (root.left != null && root.left.val - 1 == root.val) {
            result.down = Math.max(left.down + 1, 1);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            result.down = Math.max(right.down + 1, result.down);
        }
        
        int max = result.up + result.down - 1;
        
        return new Result(result.up, result.down, Math.max(Math.max(left.max, right.max), max));
    }
    
}