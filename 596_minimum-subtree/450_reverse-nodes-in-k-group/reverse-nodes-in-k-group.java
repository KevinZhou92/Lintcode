/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 17-04-03 22:52
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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        ListNode tmp = head;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (tmp == null) {
                return head;
            }
            count++;
            tmp = tmp.next;
        }
        
        if (count == k) {
            ListNode curr = reverseKGroup(tmp, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                }
                head = curr;
        }
        return head;
    }
}