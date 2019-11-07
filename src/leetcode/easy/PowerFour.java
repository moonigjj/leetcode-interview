/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 342. Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * @author tangyue
 * @version $Id: PowerFour.java, v 0.1 2019-09-06 17:13 tangyue Exp $$
 */
public class PowerFour {

    public static void main(String[] args) {

        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour1(8));
        System.out.println(isPowerOfFour2(8));
    }

    public static boolean isPowerOfFour(int n) {

        return (Math.log10(n) / Math.log10(4)) % 1 == 0;
    }

    /**
     * 4的幂必须满足如下条件：
     *
     * 1、该数必须为正。
     *
     * 2、该数的bit位上，只有1 bit。
     *
     * 3、4^n - 1 = (2^n + 1) * (2^n - 1) ，所以因式分解必然存在3 （定律：任何连续的3个数，必然存在一个数能整除3）。
     * @param n
     * @return
     */
    public static boolean isPowerOfFour1(int n) {

        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }

    /**
     * 如果不能用递归循环做，就使用位操作。1个数是2的幂肯定是4的幂，但反过来不成立，4的幂只能是奇数位为1，而2的幂只有有一个位置为1就行。
     *
     * 所以先判断是否为2的幂，然后通过与.0X55555555(....1010101)进行&操作，保留奇数位，判断是否改变
     * @param n
     * @return
     */
    public static boolean isPowerOfFour2(int n) {

        return n > 0 && (n & n - 1) == 0 && (n & 0X55555555) == n;
    }
}
