/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 *198. House Robber
 * Easy
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * @author tangyue
 * @version $Id: HouseRobber.java, v 0.1 2019-08-19 10:55 tangyue Exp $$
 */
public class HouseRobber {

    public static void main(String[] args) {

        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob1(new int[]{2,1,1,2}));
    }

    /**
     * 循环
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {

        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < len; i = i + 2) {
            odd = Math.max(odd + nums[i], even);
            if (i + 1 < len) {
                even = Math.max(even + nums[i + 1], odd);
            }
        }
        return odd > even ? odd : even;
    }

    /**
     * 类求极值的问题首先考虑动态规划Dynamic Programming来解，我们维护一个一位数组dp，其中dp[i]表示到i位置时不相邻数能形成的最大和，
     * 那么状态转移方程怎么写呢，我们先拿一个简单的例子来分析一下，比如说nums为{3, 2, 1, 5}，那么我们来看我们的dp数组应该是什么样的，
     * 首先dp[0]=3没啥疑问，再看dp[1]是多少呢，由于3比2大，所以我们抢第一个房子的3，当前房子的2不抢，所以dp[1]=3，那么再来看dp[2]，
     * 由于不能抢相邻的，所以我们可以用再前面的一个的dp值加上当前的房间值，和当前房间的前面一个dp值比较，取较大值当做当前dp值，
     * 所以我们可以得到状态转移方程dp[i] = max(num[i] + dp[i - 2], dp[i - 1]),
     * 由此看出我们需要初始化dp[0]和dp[1]，其中dp[0]即为num[0]，dp[1]此时应该为max(num[0], num[1])，代码如下
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {

        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            //if don't rob, then current will be previous sum (either robbed or non-robbed)
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            //if rob, then current will be this num + robbed previous house
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
