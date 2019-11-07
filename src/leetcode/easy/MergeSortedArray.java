/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 *Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * @author tangyue
 * @version $Id: MergeSortedArray.java, v 0.1 2019-07-09 10:20 tangyue Exp $$
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[10];
        for (int i = 0; i < 5; ++i) {
            nums1[i] = 2 * i;
        }
        System.out.println("num1: " + Arrays.toString(nums1));
        int[] nums2 = new int[5];
        for (int i = 0; i < 5; ++i) {
            nums2[i] = 2 * i + 1;
        }
        System.out.println("nums2: " + Arrays.toString(nums2));
        merge(nums1, 5, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            // i>=0且nums1[i] > nums2[j]的判断条件，
            // 就可以从nums1中取数，否则就一直从nums2中取数
            nums1[k--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }
}
