/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Java
@Datetime: 17-02-03 18:06
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
     * @return: True if the binary tree is BST, or false
     */
     
    // traverse
    private boolean firstNode = true;
    private int lastValue = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (!isValidBST(root.left)) {
            return false;
        }
        
        if (!firstNode && lastValue >= root.val ) {
            return false;
        }
        
        
        firstNode = false;
        lastValue = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        
        return true;
    }
}