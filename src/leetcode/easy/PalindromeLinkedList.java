/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import structure.ListNode;

/**
 * 234. Palindrome Linked List
 *Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * @author tangyue
 * @version $Id: PalindromeLinkedList.java, v 0.1 2019-08-23 10:59 tangyue Exp $$
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {

        System.out.println(isPalindrome(ListNode.createTestData("[1,2,3,2,1]")));
        System.out.println(isPalindrome1(ListNode.createTestData("[1,2,3,2,1]")));
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        slow = reverseList(slow);

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static boolean isPalindrome1(ListNode head) {
        if(head==null || head.next==null)
            return true;
        return check(head,head.next) != null? true : false;
    }
    public static ListNode check(ListNode slow,ListNode fast){
        if(fast == null)
            return slow;
        if(fast.next == null){
            return slow.val == slow.next.val ? slow.next : null;
        }
        fast = check(slow.next, fast.next.next);
        return fast != null && slow.val == fast.next.val ? fast.next : null;
    }
}
