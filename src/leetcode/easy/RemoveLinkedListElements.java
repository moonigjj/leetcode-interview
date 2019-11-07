/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import structure.ListNode;

/**
 * 203. Remove Linked List Elements
 *Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * @author tangyue
 * @version $Id: RemoveLinkedListElements.java, v 0.1 2019-08-21 10:01 tangyue Exp $$
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {

        ListNode listNode = removeElements(ListNode.createTestData("[1]"), 1);
       ListNode.print(listNode);
    }

    public static ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
