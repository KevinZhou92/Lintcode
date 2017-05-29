/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 17-04-11 04:17
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable.length == 0) {
            return hashTable;
        }
        
        int size = hashTable.length * 2;
        ListNode[] res = new ListNode[size];
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                ListNode dummy = hashTable[i];
                while (dummy != null) {
                    int hash_value = (dummy.val % size + size) % size;
                    if (res[hash_value] != null) {
                        ListNode tail = res[hash_value];
                        while (tail.next != null) {
                            tail = tail.next;
                        }
                        tail.next = new ListNode(dummy.val);
                    } else {
                        res[hash_value] = new ListNode(dummy.val); 
                    }
                    dummy = dummy.next;
                }
            }
        }
        return res;
    }
};
