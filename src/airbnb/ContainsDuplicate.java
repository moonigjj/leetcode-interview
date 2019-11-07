/**
 * chenxitech.cn Inc. Copyright (c) 2017-2018 All Rights Reserved.
 */
package airbnb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tangyue
 * @version $Id: ContainsDuplicate.java, v 0.1 2018-11-20 14:37 tangyue Exp $$
 */
public class ContainsDuplicate {

    //Given an array of integers, find if the array contains any duplicates. Your function should return
    //true if any value appears at least twice in the array, and it should return false if every element is distinct.
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            } else {
                map.put(i, 1);
            }
        }
        return false;
    }

    // 先排序，后判断相连的元素是否相等
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if ((nums[i] ^ nums[i + 1]) == 0){
                return true;
            }
        }
        return false;
    }

    //Given an array of integers and an integer k, find out whether there are two distinct indices i and
    //j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k >= nums.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current) && i - k <= map.get(current)) {
                return true;
            } else {
                map.put(current, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 7, 3, 2, 9};

        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate1(nums));

        int[] nums1 = {1, 2, 5, 7, 3, 2, 9};
        System.out.println(containsNearbyDuplicate(nums1, 2));
    }
}
