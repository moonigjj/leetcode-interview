/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author tangyue
 * @version $Id: ThreeSumClosest.java, v 0.1 2019-03-21 14:02 tangyue Exp $$
 */
public class ThreeSumClosest {


    public static void main(String[] args) {

        int[] nums = new int[]{1,2,4,8,16,32,64,128};
        System.out.println("==========");
        System.out.println("result: " + threeSumClosest(nums, 82));
    }

    /**
     * 16.3Sum Closest
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        // 先排序
        Arrays.sort(nums);
        int i = 0;
        int n = Integer.MAX_VALUE;
        int sum = 0;
        while (i < len - 2) {
            int temp = nums[i];
            int t = i + 1;
            int j = len - 1;
            while (t < j) {
                int k = temp + nums[t] + nums[j];
                int m = k - target;
                // 如果和小于目标值，左下标向右移，大于，则右下标向左移
                if (m < 0) {
                    t++;
                } else {
                    j--;
                }
                // 差值为负数，转换成正值比较
                if (m < 0) {
                    m = target - k;
                }
                // 小于当前最小差值交换
                if (m <= n) {
                    n = m;
                    sum = k;
                }
            }
            i++;
        }
        return sum;
    }
}
