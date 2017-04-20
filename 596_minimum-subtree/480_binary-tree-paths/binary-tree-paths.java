/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 17-02-02 17:57
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
     
     //traverse
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        String path = String.valueOf(root.val);
        helper(root, path, results);
        return results;
    }
    
    private void helper(TreeNode root, String path, List<String> results) {
        if (root == null) {
            return;
        }
        
        
        if (root.left == null && root.right == null) {
            results.add(path);
            return;
        }
        
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), results);
        }
        
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), results);
        }
    }
}