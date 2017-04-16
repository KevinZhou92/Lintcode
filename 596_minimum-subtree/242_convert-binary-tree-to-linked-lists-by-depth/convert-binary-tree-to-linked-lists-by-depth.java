/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/convert-binary-tree-to-linked-lists-by-depth
@Language: Java
@Datetime: 17-03-08 05:13
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result =  new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, 1, root);
        return result;
    }
    private void dfs(List<ListNode> result, int depth,  TreeNode root) {
        if (root == null) {
            return;
        }
        ListNode node = new ListNode(root.val);
        if (result.size() < depth) {
            result.add(node);
        } else {
            node.next = result.get(depth - 1);
            result.set(depth - 1, node);
        }
        
        dfs(result, depth + 1, root.right);
        dfs(result, depth + 1, root.left);
    }
}