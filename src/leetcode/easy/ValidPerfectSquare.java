/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 367. Valid Perfect Square
 *Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 * @author tangyue
 * @version $Id: ValidPerfectSquare.java, v 0.1 2019-09-17 10:10 tangyue Exp $$
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {

        System.out.println(isPerfectSquare(14));
    }

    /**
     * One thing to note is that we have to use long for mid to avoid mid*mid from overflow. Also, you can use long type for low and high to avoid type casting for mid from long to int.
     * And a third way is to use Newton Method to calculate the square root or num
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {

        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
