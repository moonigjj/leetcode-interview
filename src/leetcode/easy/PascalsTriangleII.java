/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 *Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 * @author tangyue
 * @version $Id: PascalsTriangleII.java, v 0.1 2019-07-17 14:01 tangyue Exp $$
 */
public class PascalsTriangleII {

    public static void main(String[] args) {

        System.out.println(getRow(5));
    }

    /**
     * 除了第一个数为1之外，后面的数都是上一次循环的数值加上它前面位置的数值之和，
     * 不停地更新每一个位置的值，便可以得到第n行的数字
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }
        return list;
    }
}
