/**
 * chenxitech.cn Inc. Copyright (c) 2017-2018 All Rights Reserved.
 */
package airbnb;

/**
 *
 * @author tangyue
 * @version $Id: HouseRobber.java, v 0.1 2018-11-20 16:13 tangyue Exp $$
 */
public class HouseRobber {

    // You are a professional robber planning to rob houses along a street.
    // Each house has a certain amount of money stashed, the only constraint stopping you from robbing
    // each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
    // Given a list of non-negative integers representing the amount of money of each house,
    // determine the maximum amount of money you can rob tonight without alerting the police.

    /**
     * 你是一个专业强盗，并计划沿街去盗窃每一个住户。
     每个房子都有一定量的现金，阻止你盗窃的唯一阻碍是相邻的两个房子之间有安全系统。
     一旦这两个房子同时被盗窃，系统就会自动联系警察。
     给定一系列非负整数代表每个房子的金钱，
     求出再不惊动警察的情况下能盗窃到的最大值

     在每个index i有两个选择：如果抢劫i，则最大收益为(抢劫i-2)＋val［i］；如果不抢劫i，则最大收益为（抢劫i-1）
     Example 1:
     Input: [1,2,3,1]
     Output: 4
     Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                  Total amount you can rob = 1 + 3 = 4.

     Example 2:
     Input: [2,7,9,3,1]
     Output: 12
     Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                  Total amount you can rob = 2 + 9 + 1 = 12.
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1){
            return nums[0];
        }
        // 动态规划，
        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
