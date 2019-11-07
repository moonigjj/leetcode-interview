/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 *Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * @author tangyue
 * @version $Id: IntersectionTwoArrays.java, v 0.1 2019-09-10 11:01 tangyue Exp $$
 */
public class IntersectionTwoArrays {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> temp = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        int n1 = nums1.length;
        for (int i = 0; i < n1; i++) {
            tmp.add(nums1[i]);
        }
        int n2 = nums2.length;
        for (int j = 0; j < n2; j++) {
            if (tmp.contains(nums2[j])) {
                temp.add(nums2[j]);
            }
        }
        int[] result = new int[temp.size()];
        int k = 0;
        for (Integer num : temp) {
            result[k++] = num;
        }
        return result;
    }
}
