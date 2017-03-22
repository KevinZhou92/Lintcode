/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 17-01-16 13:51
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */

 
 public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) { 
        return head;
    }
    
    
    ListNode h = new ListNode(0);
    h.next = head;
    ListNode p = h;
    
    while (p.next != null && p.next.next !=null) {
        ListNode t1 = p;
        p = p.next;
        t1.next = p.next;
        
        ListNode t2 = p.next;
        p.next = t2.next;
        t2.next = p;
    }
    return h.next;
     
 }
 
   
 
}