/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Java
@Datetime: 17-02-07 00:54
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
     * @param root the root of binary tree.
     * @return an integer
     */
     
    private int max = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        helper(root, root.val);
        return max;
    }
    
    private void helper(TreeNode root, int presum) {
        if (root == null) {
            return;
        }
        
        if (presum > max) {
            max = presum;
        }
        
        if (root.left != null) {
            helper(root.left, presum + root.left.val);
        }
        if (root.right != null) {
            helper(root.right, presum + root.right.val);
        }
        
        return;
    }
}
