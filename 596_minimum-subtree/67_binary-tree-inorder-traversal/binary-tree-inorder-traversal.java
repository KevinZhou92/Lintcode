/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Java
@Datetime: 17-02-02 15:22
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (root ==null) {
            return results;
        }
        
        Stack<TreeNode> pool = new Stack<>();
        TreeNode curt = root;
        while (curt != null || !pool.empty()) {
            while (curt != null) {
                pool.push(curt);
                curt = curt.left;
            }
            
            curt = pool.pop();
            results.add(curt.val);
            curt = curt.right;
            
        }
        
        return results;
    }
}