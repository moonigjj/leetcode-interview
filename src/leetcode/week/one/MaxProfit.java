package leetcode.week.one;

import java.awt.event.ItemEvent;

/**
 * Best Time to Buy and Sell Stock II
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        //[7,6,4,3,1] output: 0
        //[1,2,3,4,5] output: 4
        //[7,1,5,3,6,4] output: 7
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int len = prices.length;
        int i = 0;
        while (i < len){
            int low = prices[i];
            int diff = 0;
            int j = i + 1;
            // 选取最大值的区间
            while (j < len && prices[j] > low){
                int temp = prices[j] - low;
                if (temp > diff){
                    diff = temp;
                } else {
                    break;
                }
                j++;

            }
            max += diff;
            // 切换到下一个区间
            i = j;
        }

        return max;
    }
}
