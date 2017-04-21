/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Java
@Datetime: 17-02-03 13:20
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
     
    private class Result {
        boolean a_exist, b_exist;
        TreeNode visited;
        public Result(boolean a_exist,boolean b_exist, TreeNode visited) {
            this.a_exist = a_exist;
            this.b_exist = b_exist;
            this.visited = visited;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        Result end = helper(root, A, B);
        if (end.a_exist && end.b_exist) {
            return end.visited;
        }else {
            return null;
        }
        
         
    }
    
    private Result helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new Result(false, false, null);
        }
        
        Result left = helper(root.left, A, B);
        Result right = helper(root.right, A, B);
        
        boolean a_exist = left.a_exist || right.a_exist || root == A;  
        boolean b_exist = left.b_exist || right.b_exist || root == B;   
        
        if (root == A || root == B) {
            return new Result(a_exist, b_exist, root);
        }
        
        if (left.visited != null && right.visited != null) {
            return new Result(true, true, root);
        }
        
        if (left.visited != null ) {
            return new Result(a_exist, b_exist, left.visited);
        }
        if (right.visited != null ) {
            return new Result(a_exist, b_exist, right.visited);
        }
        
        return new Result(a_exist, b_exist, null);
        
    }
}