package leetcode.easy;

import java.util.Arrays;

/**
 *
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 *
 * Input: nums = [-1,-2,-3]
 * Output: -6
 * 628. Maximum Product of Three Numbers
 * @auTHOR TangYue
 * @date 2023/6/8
 */
public class MaximumProductThreeNumbers {

    public static void main(String[] args) {
        //int[] nums = new int[]{-1, -2, -3};
        int[] nums = new int[]{-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 定义前三个最大值变量
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        // 定义前两个最小值变量
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            // 做比较并进行替换，从后往前
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        // 同样是取两者之间的较大者
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}
