/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import structure.ListNode;

/**
 * 06. Reverse Linked List
 *Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * @author tangyue
 * @version $Id: ReverseLinkedList.java, v 0.1 2019-08-22 10:31 tangyue Exp $$
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode.print(reverseList(ListNode.createTestData("[1,2,3,4,5]")));
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
