package leetcode.easy;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 506. Relative Ranks
 * Easy
 *
 * 7
 *
 * 0
 *
 * Add to List
 *
 * Share
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
 *
 * The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
 *
 * The 1st place athlete's rank is "Gold Medal".
 * The 2nd place athlete's rank is "Silver Medal".
 * The 3rd place athlete's rank is "Bronze Medal".
 * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 *
 *
 *
 * Example 1:
 *
 * Input: score = [5,4,3,2,1]
 * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 * Example 2:
 *
 * Input: score = [10,3,8,9,4]
 * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 */
public class RelativeRanks {

    public static void main(String[] args) {

        int[] score = new int[]{10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    /**
     * 排序保留下标
     * @param score
     * @return
     */
    public static String[] findRelativeRanks(int[] score) {
        int len = score.length;
        if (len == 0) {
            return new String[0];
        }
        int maxValue = IntStream.of(score).max().getAsInt();
        /**
         * 使用桶排序
         */
        int[] buckets = new int[maxValue + 1];
        for (int i = 0; i < len; i++){
            buckets[score[i]] = i + 1;
        }

        int place = 1;
        String[] result = new String[len];
        for (int i = maxValue; i >=0; i--) {
            if (buckets[i] == 0) {
                continue;
            }
            if (place <= 3) {
                switch (place) {
                    case 1:
                        result[buckets[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        result[buckets[i] - 1] = "Silver Medal";
                        break;
                    default:
                        result[buckets[i] - 1] = "Bronze Medal";
                        break;
                }
            } else {
                result[buckets[i] - 1] = String.valueOf(place);
            }
            place++;
        }
        return result;
    }
}
