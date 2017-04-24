/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 17-03-20 19:44
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode left = new ListNode(0);
        ListNode left_head = left;
        ListNode right = new ListNode(0);
        ListNode right_head = right;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
                head = head.next;
            }else {
                right.next = head;
                right = head;
                head = head.next;
            }
        }
        right.next = null;
        left.next = right_head.next;
        
        return left_head.next;
    }
}
