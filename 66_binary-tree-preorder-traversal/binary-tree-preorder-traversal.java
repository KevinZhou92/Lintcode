/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Java
@Datetime: 17-02-02 15:04
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        
        Stack<TreeNode> pool = new Stack<>();
        pool.push(root);
        while (!pool.empty()) {
            TreeNode curt = pool.pop();
            if (curt.right != null) {
                pool.push(curt.right);
            }
            
            if (curt.left != null) {
                pool.push(curt.left);
            }
            
            results.add(curt.val);
            curt = curt.left;
        }
        return results;
    }
}