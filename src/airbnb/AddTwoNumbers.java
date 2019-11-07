/**
 * chenxitech.cn Inc. Copyright (c) 2017-2018 All Rights Reserved.
 */
package airbnb;

import structure.ListNode;

/**
 * @author tangyue
 * @version $Id: AddTwoNumbers.java, v 0.1 2018-11-20 14:09 tangyue Exp $$
 */
public class AddTwoNumbers {

    // You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode current1 = l1;
        ListNode current2 = l2;

        int sum = 0;// 结点和
        ListNode head = new ListNode(0);//头结点
        while (current1 != null || current2 != null) {
            // 进位数
            sum /= 10;
            if (current1 != null){
                sum += current1.val;
                current1 = current1.next;
            }
            if (current2 != null){
                sum += current2.val;
                current2 = current2.next;
            }
            // 设置当前头结点的下一个结点
            head.next = new ListNode(sum % 10);
            // 移动头结点指向下一个结点
            head = head.next;
        }
        // 循环结束，sum不为0，表示有进位
        if (sum / 10 == 1){
            head.next = new ListNode(1);
        }
        return head.next;
    }
}
