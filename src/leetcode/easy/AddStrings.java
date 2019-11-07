/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 415. Add Strings
 *Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @author tangyue
 * @version $Id: AddStrings.java, v 0.1 2019-10-24 9:44 tangyue Exp $$
 */
public class AddStrings {

    public static void main(String[] args) {

        System.out.println(addStrings("123", "1239"));
    }

    public static String addStrings(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        int max = Math.max(len1, len2);
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int sum = carry;
            if (len1 > i) {
                sum += num1.charAt(len1 - 1 - i) - '0';
            }
            if (len2 > i) {
                sum += num2.charAt(len2 - 1 - i) - '0';
            }

            sb.insert(0, sum % 10);
            carry = sum / 10;
        }

        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
