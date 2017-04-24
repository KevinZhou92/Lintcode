/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Java
@Datetime: 17-03-27 16:48
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    private ListNode findMid(ListNode start) {
        ListNode slow = start;
        ListNode fast = start.next; 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode left_head = new ListNode(0), left_tail = left_head;
        ListNode right_head = new ListNode(0), right_tail = right_head;
        ListNode mid_head = new ListNode(0), mid_tail = mid_head;
        
        while (head != null) {
            if (head.val < mid.val) {
                left_tail.next = head;
                left_tail = head;
            } else if (head.val > mid.val) {
                right_tail.next = head;
                right_tail = head;
            } else {
                mid_tail.next = head;
                mid_tail = head;
            }
            head = head.next;
        }
        
        left_tail.next = null;
        right_tail.next = null;
        mid_tail.next = null;
        
        ListNode left = sortList(left_head.next);
        ListNode right = sortList(right_head.next);
        
        ListNode end = new ListNode(0), dummy = end;
        end.next = left;
        end = getTail(end);
        end.next = mid_head.next;
        end = getTail(end);
        end.next = right;
        end = getTail(end);
        
        return dummy.next;
    }
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return head;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}
