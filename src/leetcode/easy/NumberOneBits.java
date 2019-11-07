/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 191. Number of 1 Bits
 *Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * @author tangyue
 * @version $Id: NumberOneBits.java, v 0.1 2019-08-19 10:46 tangyue Exp $$
 */
public class NumberOneBits {

    public static void main(String[] args) {

        System.out.println(hammingWeight(3));
        System.out.println(hammingWeight1(3));
    }

    /**
     * 依次移动位数进行计算。
     * The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.
     * So when the first bit is 1, if use >>, 1 will always be there, then the loop will never end.
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            // must use unsigned operation
            n = n >>> 1;
        }
        return count;
    }

    /**
     * consider n & (n - 1) always eliminates the least significant 1.
     * @param n
     * @return
     */
    public static int hammingWeight1(int n) {

        int count = 0;
        // loop times = number of 1's in the n
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
