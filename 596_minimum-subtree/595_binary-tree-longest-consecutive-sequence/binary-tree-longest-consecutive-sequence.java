/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence
@Language: Java
@Datetime: 17-02-05 16:47
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
     
    private class Result {
        int max, current;
        public Result(int currentlength,int max) {
            this.current = currentlength;
            this.max = max;
        }
    }
    public int longestConsecutive(TreeNode root) {
        return helper(root).max;
    }
    
    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result current = new Result(1, 0);
        if (root.left != null && root.val == root.left.val - 1) {
            current.current = left.current + 1;
        }
        
        if (root.right != null && root.val == root.right.val - 1) {
            current.current = Math.max(current.current, right.current + 1);
        } 
        
        
        current.max = Math.max(Math.max(left.max, right.max), current.current);
        return current;
    }
}