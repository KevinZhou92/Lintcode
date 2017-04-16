/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum-ii
@Language: Java
@Datetime: 17-02-08 19:47
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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        
        helper(root, 0, target, buffer, results);
        return results;
        
    }
    private void helper(TreeNode root, int level, int sum, ArrayList<Integer> buffer, List<List<Integer>> results) {
        
        if (root == null) {
            return;
        }
        
        buffer.add(root.val);
        int temp = sum;
        for (int i = level; i >= 0;  i--) {
            temp -= buffer.get(i);
            if (temp == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int j = i; j <= level; j++) {
                    tmp.add(buffer.get(j));
                }
                results.add(new ArrayList<Integer>(tmp));
            }
        }
        
        helper(root.left, level + 1, sum, buffer, results);
        helper(root.right, level + 1, sum, buffer, results);
        buffer.remove(buffer.size() - 1);
        
    }
}