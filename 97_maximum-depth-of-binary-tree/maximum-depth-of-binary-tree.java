/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/maximum-depth-of-binary-tree
@Language: Java
@Datetime: 17-02-07 00:20
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
     * @return: An integer.
     */
     
    int longest = 0;
    public int maxDepth(TreeNode root) {
        helper (root, 1);
        return longest;
    }
    
    private void helper(TreeNode root, int preLen) {
        if (root == null) {
            return;
        }
        
        helper(root.left, preLen + 1);
        helper(root.right, preLen + 1);
        
        if (preLen > longest) {
            longest = preLen;
        }
        return;
    }
}