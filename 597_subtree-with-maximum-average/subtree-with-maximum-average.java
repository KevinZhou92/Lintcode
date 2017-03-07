/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subtree-with-maximum-average
@Language: Java
@Datetime: 17-01-31 00:54
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    
    private class Result {
        int sum, size;
        public Result(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
    private TreeNode result = null;
    private Result subtree = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return result;
    }
    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result current = new Result(left.sum + right.sum + root.val, left.size + right.size + 1);
        
        if (subtree == null || current.sum * subtree.size > current.size * subtree.sum) {
            result = root;
            subtree = current;
        }
        
        return current;
    }
}