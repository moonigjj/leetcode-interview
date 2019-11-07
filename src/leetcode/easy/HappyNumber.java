/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.HashSet;

/**
 * 202. Happy Number
 *Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @author tangyue
 * @version $Id: HappyNumber.java, v 0.1 2019-08-20 13:56 tangyue Exp $$
 */
public class HappyNumber {

    public static void main(String[] args) {

        System.out.println(isHappy(19));
        System.out.println(isHappy1(19));
    }

    public static boolean isHappy(int n) {

        if (n < 1) {
            return false;
        }

        HashSet<Integer> temp = new HashSet<>();

        int tmp;
        int s;
        // n不为1，并且n的值不能重复出现，否则会死循环
        while (n != 1 && !temp.contains(n)) {
            temp.add(n);
            s = 0;
            while (n > 0) {
                tmp = n % 10;
                n /= 10;
                s += tmp * tmp;
            }
            n = s;
        }

        return n == 1;
    }

    /**
     * 快慢指针，相等存在环
     * 弗洛伊德环检测算法（Floyd Cycle Detection Algorithm）
     * @param n
     * @return
     */
    public static boolean isHappy1(int n) {

        int fast = next(n); // fast指针先进行一步操作
        int slow = n;
        while (fast != slow) {
            slow = next(slow); // slow指针进行一步操作
            fast = next(next(fast)); // fast指针进行两步操作
        }
        return fast == 1;
    }

    private static int next(int n) {
        int temp = 0;
        int low;
        while (n > 0) {
            low = n % 10;
            n /= 10;
            temp += low * low;
        }
        return temp;
    }
}
