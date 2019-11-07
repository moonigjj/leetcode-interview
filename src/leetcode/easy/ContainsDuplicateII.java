/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II Given an array of integers and an integer k, find out whether there
 * are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute
 * difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3 Output: true Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1 Output: true Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 *
 * @author tangyue
 * @version $Id: ContainsDuplicateII.java, v 0.1 2019-08-23 10:23 tangyue Exp $$
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    /**
     * 滑动窗口的方法来进行求解，滑动窗口的大小为k，用HashSet来存储该窗口内的值，
     * 同时用来判断窗口内的数字是否重复出现。同时使用两个指针left和right标记窗口的两端
     * ，刚开始值都为0，然后对right不断加1，将right指向的值加入HashSet中去，判断是否出现重复值，
     * 直到righ-left>k，left加1，并移除相应的元素。
     * 如果到数组末尾没有发现重复的值则返回false
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                right++;
            } else {
                return true;
            }
            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }

}
