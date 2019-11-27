/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 441. Arranging Coins
 *You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 * @author tangyue
 * @version $Id: ArrangingCoins.java, v 0.1 2019-11-14 11:10 tangyue Exp $$
 */
public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }



    public static int arrangeCoins(int n) {

        int i = 0;
        while (n > 0) {
            i++;
            n -= i;
        }
        return n== 0 ? i : i - 1;
    }
}
