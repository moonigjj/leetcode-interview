/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 190. Reverse Bits
 *Reverse bits of a given 32 bits unsigned integer.
 *
 *
 *
 * Example 1:
 *
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * @author tangyue
 * @version $Id: ReverseBits.java, v 0.1 2019-08-16 16:28 tangyue Exp $$
 */
public class ReverseBits {

    public static void main(String[] args) {

        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits1(43261596));
    }

    // you need treat n as an unsigned value
    //设这个数为k，用一个初值为0的数r保存反转后的结果，用1对k进行求与
    // ，其结果与r进行相加，再对k向右进行一位移位，对r向左进行一位移位。值到k的最后一位处理完。
    public static int reverseBits1(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    public static int reverseBits(int n) {
        if(n == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i< 32; i++){
            res <<= 1;
            if((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }
}
