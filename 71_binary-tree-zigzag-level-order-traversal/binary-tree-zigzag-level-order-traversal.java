/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 17-04-30 20:33
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> curlevel = new Stack<>();
        Stack<TreeNode> nextlevel = new Stack<>();
        Stack<TreeNode> tmp = new Stack<>();
        boolean flag = true;
        
        curlevel.push(root);
        
        while (!curlevel.isEmpty()) {
            ArrayList<Integer> path = new ArrayList<>();
            while (!curlevel.isEmpty()) {
                TreeNode cur = curlevel.pop();
                path.add(cur.val);
                if (flag) {
                    if (cur.left != null) {
                        nextlevel.push(cur.left);
                    }
                    if (cur.right != null) {
                        nextlevel.push(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        nextlevel.push(cur.right);
                    }
                    if (cur.left != null) {
                        nextlevel.push(cur.left);
                    }
                }
            }
            
            tmp = curlevel;
            curlevel = nextlevel;
            nextlevel = tmp;
            res.add(path);
            flag = !flag;
        }
        return res;
    }
}