package leetcode.week.one;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12,0,9};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len - 1){
            if (nums[i] == 0){
                int j = i + 1;
                while (j < len - 1 && nums[j] == 0){
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
        }
    }

    public static void moveZeroes1(int[] nums){
        int count = 0;
        for(int i =0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[count] = nums[i];
                if(count != i){
                    nums[i] =0;
                }
                count++;
            }
        }
    }
}
