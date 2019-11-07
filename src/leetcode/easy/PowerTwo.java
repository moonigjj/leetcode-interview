/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 *
 * @author tangyue
 * @version $Id: PowerofTwo.java, v 0.1 2019-08-23 10:52 tangyue Exp $$
 */
public class PowerTwo {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo1(16));
    }

    /**
     * 位操作，如果一个数是2的幂，其2进制表示位置只有最高位1，则(n&n-1)==0
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwo1(int n) {

        return (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }
}
