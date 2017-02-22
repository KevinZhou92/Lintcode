/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 17-02-02 00:12
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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return (helper(root) != -1);
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        int height = Math.max(Math.max(leftHeight, rightHeight) + 1, 1);
        
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return height;
        
    }
}