/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 17-02-08 05:18
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        DoublyListNode head = new DoublyListNode(0);
        DoublyListNode tracker = head;
        
        Stack<TreeNode> pool = new Stack<TreeNode>();
        TreeNode node = root;
        pool.push(node);
        
        while(!pool.empty()) {
            while (node != null && node.left != null) {
                node = node.left;
                pool.push(node);
            }
            
            node = pool.pop();
            DoublyListNode current = new DoublyListNode(node.val);
            tracker.next = current;
            current.prev = current;
            tracker = current;
            
            node = node.right;
            if (node != null) {
               pool.push(node); 
            }
        }
        return head.next;
    }
}
