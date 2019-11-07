/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: KSum.java, v 0.1 2019-04-08 14:32 tangyue Exp $$
 */
public class KSum {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> kSum(int[] nums, int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return result;
        }
        // 先排序
        Arrays.sort(nums);

        return result;
    }

}
