/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 *Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * @author tangyue
 * @version $Id: IntersectionTwoArraysII.java, v 0.1 2019-09-17 9:47 tangyue Exp $$
 */
public class IntersectionTwoArraysII {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> tmp = new HashMap<>();
        int n1 = nums1.length;
        for (int i = 0; i < n1; i++) {

            Integer num1 = nums1[i];
            if (tmp.containsKey(num1)) {
                tmp.put(num1, tmp.get(num1) + 1);
            } else {

                tmp.put(num1, 1);
            }
        }
        int n2 = nums2.length;
        for (int j = 0; j < n2; j++) {

            Integer num2 = nums2[j];
            if (tmp.containsKey(num2) && tmp.get(num2) > 0) {
                temp.add(num2);
                Integer value2 = tmp.get(num2) - 1;
                tmp.put(num2, value2);
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
