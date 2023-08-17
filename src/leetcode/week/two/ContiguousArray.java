package leetcode.week.two;

/**
 * Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,0,1};
        int length = findMaxLength(nums);
        System.out.println(length);
    }

    /**
     * 连续子序列
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        // 前一位
        int preNum = nums[0];
        // 最大长度
        int maxLen = 0;
        int counter = 1;
        for (int i = 1; i < len; i++){
            int num = nums[i];
            if (preNum != num){
                counter++;
            } else {
                if (maxLen < counter){
                    maxLen = counter;
                }
                counter = 1;
            }
            preNum = num;
        }
        if (maxLen < counter){
            maxLen = counter;
        }
        return maxLen;
    }
}
