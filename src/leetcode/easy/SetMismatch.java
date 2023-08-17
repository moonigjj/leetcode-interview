package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 645. Set Mismatch
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 * @auTHOR TangYue
 * @date 2023/6/27
 */
public class SetMismatch {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int total = len * (len + 1) / 2;
        int[] res = new int[2];
        for (int num : nums){
            num = Math.abs(num);
            sum += num;
            if (nums[num - 1] < 0){
                res[0] = num;
            } else {
                nums[num - 1] *= -1;
            }
        }
        res[1] = res[0] - sum + total;
        return res;
    }
}
