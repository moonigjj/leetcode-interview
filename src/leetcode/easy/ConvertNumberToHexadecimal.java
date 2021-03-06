/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 *
 * 405. Convert a Number to Hexadecimal
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 * @author tangyue
 * @version $Id: ConvertNumberToHexadecimal.java, v 0.1 2019-10-16 11:02 tangyue Exp $$
 */
public class ConvertNumberToHexadecimal {

    public static void main(String[] args) {

        System.out.println(toHex(26));
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder s = new StringBuilder();
        while (num != 0) {
            int temp = num & 0xf;
            if (temp < 10) {
                s.append((char)(temp + '0'));
            } else {
                s.append((char)(temp - 10 + 'a'));
            }
            num >>>= 4;
        }
        return s.reverse().toString();
    }
}
