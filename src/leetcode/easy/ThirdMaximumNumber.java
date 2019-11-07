/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 414. Third Maximum Number
 *Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * @author tangyue
 * @version $Id: ThirdMaximumNumber.java, v 0.1 2019-10-22 13:56 tangyue Exp $$
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {

        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }

    public static int thirdMax(int[] nums) {

        Integer[] max = new Integer[3];
        for (Integer n : nums) {
            if (n.equals(max[0])
                    || n.equals(max[1])
                    || n.equals(max[2])) {
                continue;
            }
            if (max[0] == null || max[0] < n) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = n;
            } else if (max[1] == null || max[1] < n) {
                max[2] = max[1];
                max[1] = n;
            } else if (max[2] == null || max[2] < n) {
                max[2] = n;
            }
        }

        return max[2] == null ? max[0] : max[2];
    }
}
