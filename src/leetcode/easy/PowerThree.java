/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 *326. Power of Three
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 *
 * Input: 27
 * Output: true
 * Example 2:
 *
 * Input: 0
 * Output: false
 * Example 3:
 *
 * Input: 9
 * Output: true
 * Example 4:
 *
 * Input: 45
 * Output: false
 * @author tangyue
 * @version $Id: PowerThree.java, v 0.1 2019-09-06 17:01 tangyue Exp $$
 */
public class PowerThree {

    public static void main(String[] args) {

        System.out.println(isPowerOfThree(6));
        System.out.println(isPowerOfThree1(6));
    }

    /**
     * The idea is to convert the original number into
     * radix-3 format and check if it is of format 10*where 0* means k zeros with k>=0.
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {

        return Integer.toString(n, 3).matches("10*");
    }

    /**
     * 对数
     * 一个基本的事实就是如果n是3的x次方，那么以3为低对数后一定是一个整数，否则不是
     * @param n
     * @return
     */
    public static boolean isPowerOfThree1(int n) {

        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
