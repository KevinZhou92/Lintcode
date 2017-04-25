/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/minimum-subtree
@Language: Java
@Datetime: 17-01-30 23:36
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
     * @return the root of the minimum subtree
     */
     
    private class Result {
        int sum;
        public Result(int sum) {
            this.sum = sum;
        }
    }
    
    private TreeNode result = null;
    private int min = 0;
    
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return result;
        
    }
    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0);
        }
        
        Result left = helper(root.left);
        Result right  = helper(root.right);
        Result current =  new Result(left.sum + right.sum + root.val);
        
        if(result == null || current.sum < min) {
            min = current.sum;
            result = root;
        }
        
        return current;
        
    }
}