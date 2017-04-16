/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-02-03 01:32
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
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, root.val, target, path, results);
        return results;
    }
    private void helper(TreeNode root, int sum, int target, ArrayList<Integer> path, List<List<Integer>> results) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
                results.add(new ArrayList<Integer>(path));
                return;
            }
            return;
        }
            
            if (root.left != null) {
                path.add(root.left.val);
                helper(root.left, sum + root.left.val, target, path, results);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                path.add(root.right.val);
                helper(root.right, sum + root.right.val, target, path, results);
                path.remove(path.size() - 1);
            }
        }
    }
