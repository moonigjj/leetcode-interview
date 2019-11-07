/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.medium;

import structure.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * @author tangyue
 * @version $Id: SwapPairs.java, v 0.1 2019-05-24 15:37 tangyue Exp $$
 */
public class SwapPairs {

    public static void main(String[] args) {

        ListNode.print(swapPairs(ListNode.createTestData("[1,2,3,4]")));
        System.out.println("============================");
        ListNode.print(swapPairs1(ListNode.createTestData("[5,6,7,8]")));
    }

    // 迭代
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = new ListNode(0);
        ListNode dummy = tmp;
        tmp.next = head;
        while (dummy.next != null && dummy.next.next != null){
            ListNode temp = dummy.next.next; // 1
            dummy.next.next = temp.next; // 2
            temp.next = dummy.next;
            dummy.next = temp;
            dummy = dummy.next.next;
        }
        return tmp.next;
    }

    /**
     * 递归遍历到链表末尾，然后先交换末尾两个，然后依次往前交换
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head.next;
        head.next = swapPairs1(head.next.next);
        tmp.next = head;
        return tmp;
    }
}
