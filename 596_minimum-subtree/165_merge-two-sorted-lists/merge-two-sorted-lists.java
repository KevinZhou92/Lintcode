/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-lists
@Language: Java
@Datetime: 17-03-17 01:44
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
       
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                dummy = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                dummy = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            dummy.next = l1;  
        }
        if (l2 != null) {
            dummy.next = l2;  
        }
        return start.next;
    }
}