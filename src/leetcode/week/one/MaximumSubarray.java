package leetcode.week.one;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};//[-2,1,-3,4,-1,2,1,-5,4] output: 6
        System.out.println(maxSubArray(nums));
    }

    /**
     * 寻找小区间的最小和最大值相加
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums){
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }
}
