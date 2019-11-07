/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.3Sum
 *Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
 * @author tangyue
 * @version $Id: ThreeSum.java, v 0.1 2019-03-22 10:02 tangyue Exp $$
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -4};
        System.out.println("==========");
        System.out.println("result: " + threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return result;
        }
        // 先排序
        Arrays.sort(nums);
        int i = 0;
        while (i < len - 2) {
            int temp = nums[i];
            int t = i + 1;
            // 当前num[i]等于num[i - 1]
            if (i > 0 && temp == nums[i - 1]){
                i++;
                continue;
            }
            int j = len - 1;

            while (t < j) {
                // 跳过右则的值
                if (j < len - 1 && nums[j] == nums[j + 1]){
                    j--;
                    continue;
                }
                int k = temp + nums[t] + nums[j];
                // 如果和小于目标值，左下标向右移，大于，则右下标向左移
                // 相等都向中心移动
                if (k == 0) {
                    result.add(Arrays.asList(temp, nums[t], nums[j]));
                    j--;
                    t++;
                } else if (k > 0){
                    j--;
                } else {
                    t++;
                }
            }
            i++;
        }
        return result;
    }
}
