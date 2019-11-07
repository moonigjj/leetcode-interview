/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.medium;

/**
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 * @author tangyue
 * @version $Id: DivideTwoIntegers.java, v 0.1 2019-06-18 9:46 tangyue Exp $$
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {

        System.out.println(divide(-2147483648, 2));
    }

    /**
     * Example 1:
     *
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Example 2:
     *
     * Input: dividend = 7, divisor = -3
     * Output: -2
     *
     * 将整数转化成二进制形式，即num = a0*2^0 + a1*2^1 + a2*2^2 + ... + an*2^n。
     * 基于以上这个公式以及左移一位相当于乘以2，可以先让除数左移直到大于被除数之前得到一个最大的基数。然后每次用被除数去减去这个基数，
     * 同时结果增加2^k。接下来继续重新左移除数左移迭代，直到被除数不大于除数为止。因为这个方法的迭代次数是按2的幂直到结束，所以时间复杂度为O(logn)。

     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        // 取绝对值 负整数转换成正整数会有溢出
        long dvd = Math.abs((long)dividend);
        long dvr = Math.abs((long)divisor);
        int res = 0;
        while (dvd >= dvr){
            long tmp = dvr;
            long multiple = 1;
            while (dvd >= tmp << 1){
                tmp <<= 1;
                multiple <<= 1;
            }
            dvd -= tmp;
            res += multiple;
        }
        // 如果有一个小于0，返回负数
        return (dividend < 0) ^ (divisor < 0) ? -res : res;
    }
}
