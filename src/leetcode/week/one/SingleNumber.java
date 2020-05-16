package leetcode.week.one;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 1, 2, 2, 1};
        System.out.println(singleNumber(nums));
        System.out.println(sum(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int fast = 0;
        int slow = 0;
        while (fast < len){
            int diff = 0;
            while (fast < len && nums[slow] == nums[fast]){
                diff++;
                fast++;
            }
            if (diff == 1){
                return nums[slow];
            }
            slow = fast;
        }
        return nums[0];
    }

    public static int sum(int[] nums){
        int sum = 0;
        for (int num : nums){
            sum ^= num;
        }
        return sum;
    }
}
