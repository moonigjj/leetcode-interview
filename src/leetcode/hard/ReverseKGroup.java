/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.hard;

import structure.ListNode;

/**
 *Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 需要两个函数，一个是用来分段的，一个是用来翻转的
 * @author tangyue
 * @version $Id: ReverseKGroup.java, v 0.1 2019-05-24 16:20 tangyue Exp $$
 */
public class ReverseKGroup {

    public static void main(String[] args) {

        ListNode.print(reverseKGroup(ListNode.createTestData("[1,2,3,4,5,6,7,8]"), 3));
        System.out.println("=============group1=========");
        ListNode.print(reverseKGroup1(ListNode.createTestData("[1,2,3,4,5,6,7,8]"), 3));
        System.out.println("=============group2=========");
        //ListNode.print(reverseKGroup2(ListNode.createTestData("[1,2,3,4,5,6,7,8]"), 3));
    }

    /**
     * 首先遍历整个链表，统计出链表的长度，然后如果长度大于等于k，我们开始交换节点，当 k=2 时，每段我们只需要交换一次，当 k=3 时，
     * 每段需要交换2此，所以i从1开始循环，注意交换一段后更新 pre 指针，然后 num 自减k，直到 num<k 时循环结束
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k){
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = pre;
        dummy.next = head;
        int num = 0;
        while (cur != null){
            cur = cur.next;
            num++;
        }
        while (num >= k) {
            cur = pre.next;
            for (int i = 1; i < k; i++) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            num -= k;
        }
        return dummy.next;
    }

    /**
     * 只要 cur 走过k个节点，那么 next 就是 cur->next，就可以调用翻转函数来进行局部翻转了，注意翻转之后新的 cur 和 pre 的位置都不同了
     * ，那么翻转之后，cur 应该更新为 pre->next，而如果不需要翻转的话，cur 更新为 cur->next
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;
        for (int i = 1; cur != null; i++) {
            if (i % k == 0){
                pre = reverseOneGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    private static ListNode reverseOneGroup(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    /**
     * 用 head 记录每段的开始位置，cur 记录结束位置的下一个节点，然后我们调用 reverse 函数来将这段翻转，
     * 然后得到一个 new_head，原来的 head 就变成了末尾，这时候后面接上递归调用下一段得到的新节点，返回 new_head 即可
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // head记录每段开始位置，tail记录结束位置的下一个节点
        ListNode node = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return node;
    }

    // 反转节点
    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = tail;
        while (head != tail) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
