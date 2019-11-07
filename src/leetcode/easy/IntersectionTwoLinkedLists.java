/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import structure.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * @author tangyue
 * @version $Id: IntersectionTwoLinkedLists.java, v 0.1 2019-07-22 17:17 tangyue Exp $$
 */
public class IntersectionTwoLinkedLists {

    public static void main(String[] args) {

        ListNode headA = ListNode.createTestData("[4,1,8,4,5]");
        ListNode headB = ListNode.createTestData("[5,0,1,8,4,5]");
        ListNode.print(getIntersectionNode1(headA, headB));
        ListNode.print(getIntersectionNode(headA, headB));
    }

    /**
     * 具体算法为：分别遍历两个链表，得到分别对应的长度。
     * 然后求长度的差值，把较长的那个链表向后移动这个差值的个数，然后一一比较即可
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null) ? headA : null;
    }

    private static int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 虽然题目中强调了链表中不存在环，但是我们可以用环的思想来做，我们让两条链表分别从各自的开头开始往后遍历，
     * 当其中一条遍历到末尾时，我们跳到另一个条链表的开头继续遍历。两个指针最终会相等，而且只有两种情况，
     * 一种情况是在交点处相遇，另一种情况是在各自的末尾的空节点处相等
     * 。为什么一定会相等呢，因为两个指针走过的路程相同，是两个链表的长度之和，所以一定会相等
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {

            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return null;
    }
}
