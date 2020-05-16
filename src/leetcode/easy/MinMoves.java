package leetcode.easy;

/**
 * 453. Minimum Moves to Equal Array Elements
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinMoves {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(minMoves(nums));
    }

    /**
     * 每次操作n-1个元素加1，等效剩下的元素相对减1
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            sum += num;
            if (num < min){
                min = num;
            }
        }
        return sum - min * len;
    }
}
