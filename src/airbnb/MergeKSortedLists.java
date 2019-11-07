/**
 * chenxitech.cn Inc. Copyright (c) 2017-2018 All Rights Reserved.
 */
package airbnb;

import java.util.Comparator;
import java.util.PriorityQueue;

import structure.ListNode;

/**
 * 将k个已排好序的链表合并为一个排序的链表
 * K-way merge最典型的解法就是用heap了，时间复杂度可以达到n*logk
 * @author tangyue
 * @version $Id: MergeKSortedLists.java, v 0.1 2018-11-20 17:10 tangyue Exp $$
 */
public class MergeKSortedLists {

    // Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    public static ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return lists[0];
        }
        //优先级队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // 先对数组中的队列进行排序
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }

}
