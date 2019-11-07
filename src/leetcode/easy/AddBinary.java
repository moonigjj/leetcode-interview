/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * @author tangyue
 * @version $Id: AddBinary.java, v 0.1 2019-07-09 9:42 tangyue Exp $$
 */
public class AddBinary {

    public static void main(String[] args) {

        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int count = 0;
        String sb = "";
        while (m > 0 || n > 0) {
            m--;
            n--;
            int i = m >= 0 ? a.charAt(m) - '0' : 0;
            int j = n >= 0 ? b.charAt(n) - '0' : 0;
            int sum = i + j + count;
            // 对2取余即为当前位的数字，对2取商即为当前进位的值
            sb = sum % 2 + sb;
            count = sum / 2;
        }

        // 最后还要判断下carry，如果为1的话，要在结果最前面加上一个1
        if (count == 1) {
            sb = count + sb;
        }
        return sb;
    }
}
