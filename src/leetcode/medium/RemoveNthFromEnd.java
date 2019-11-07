/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.medium;

import structure.ListNode;

/**
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 * @author tangyue
 * @version $Id: RemoveNthFromEnd.java, v 0.1 2019-05-08 13:50 tangyue Exp $$
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {

    }

    /**
     * 思路：
     * 一头一尾下标相差n, 尾指标到达end, 头指标到达n-2, next为remove的node
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode slow = head, fast = head;
        // move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        // move fast to the end, maintaining the gap
        ListNode prev = null;
        while (fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev != null){
            // delete slow by pointing prev next to slow next
            prev.next = slow.next;
        }
        // handle first element delete
        // prev is null, fast.next is null
        return prev == null ? head.next : head;
    }
}
