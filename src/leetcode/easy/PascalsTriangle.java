/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 杨辉三角形第n层（顶层称第0层，第1行，第n层即第 n+1 行，此处n为包含0在内的自然数）正好对应于二项式 \left(a+b\right)^{n} 展开的系数。例如第二层 1 2 1 是幂指数为2的二项式 \left(a+b\right)^{2} 展开形式 a^{2}+2ab+b^{2} 的系数。
 *
 *
 *
 * 杨辉三角主要有下列五条性质：
 *
 * 杨辉三角以正整数构成，数字左右对称，每行由1开始逐渐变大，然后变小，回到1。
 * 第n行的数字个数为n个。
 * 第n行的第k个数字为组合数 C_{n-1}^{k-1}。
 * 第n行数字和为 2^{n-1}。
 * 除每行最左侧与最右侧的数字以外，每个数字等于它的左上方与右上方两个数字之和（也就是说，第n行第k个数字等于第 n-1 行的第 k-1 个数字与第k个数字的和）。这是因为有组合恒等式：C_{n}^{i}=C_{n-1}^{i-1}+C_{n-1}^{i}。可用此性质写出整个杨辉三角形。
 *
 * @author tangyue
 * @version $Id: PascalsTriangle.java, v 0.1 2019-07-17 13:51 tangyue Exp $$
 */
public class PascalsTriangle {

    public static void main(String[] args) {

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    sub.add(1);
                } else {
                    // 获取上一行数组
                    List<Integer> preSub = list.get(i - 1);
                    sub.add(preSub.get(j - 1) + preSub.get(j));
                }
            }
            list.add(sub);
        }
        return list;
    }
}
