/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.hard;

import java.util.PriorityQueue;

import structure.ListNode;

/**
 *Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author tangyue
 * @version $Id: MergeKLists.java, v 0.1 2019-05-24 13:55 tangyue Exp $$
 */
public class MergeKLists {
    public static void main(String[] args) {

        ListNode[] listNodes = new ListNode[]{
                ListNode.createTestData("[1,3,5,7]"),
                ListNode.createTestData("[2,4,6]")
        };
        ListNode.print(mergeKLists(listNodes));
        System.out.println("==============================");
        ListNode[] listNodes1 = new ListNode[]{
                ListNode.createTestData("[1,3,5,7]"),
                ListNode.createTestData("[2,4,6]")
        };
        ListNode.print(mergeKLists1(listNodes1));
    }

    // 分治 Divide and Conquer Approach
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i< n / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            }
            n = k;
        }
        return lists[0];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }

    /**
     * 这种解法利用了最小堆这种数据结构，我们首先把k个链表的首元素都加入最小堆中，它们会自动排好序。
     * 然后我们每次取出最小的那个元素加入我们最终结果的链表中，然后把取出元素的下一个元素再加入堆中，
     * 下次仍从堆中取出最小的元素做相同的操作，以此类推，直到堆中没有元素了，此时k个链表也合并为了一个链表，
     * 返回首节点即可
     * @param lists
     * @return
     */

    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> queue=  new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) return -1;
            else if (o1.val == o2.val) return 0;
            else return 1;
        });

        ListNode dummy  =  new ListNode(0);
        ListNode tmp = dummy ;
        for (ListNode node : lists) {
            if (node != null){
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;
            if (tmp.next != null) {
                queue.add(tmp.next);
            }
        }
        return dummy.next;
    }
}
