/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 * 204. Count Primes
 *Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * @author tangyue
 * @version $Id: CountPrimes.java, v 0.1 2019-08-21 10:26 tangyue Exp $$
 */
public class CountPrimes {

    public static void main(String[] args) {

        System.out.println(countPrimes(10));
    }

    /**
     * 从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，然后到下一个质数3，
     * 标记其所有倍数，一次类推，直到根号n，此时数组中未被标记的数字就是质数。
     * 我们需要一个 n-1 长度的 bool 型数组来记录每个数字是否被标记，
     * 长度为 n-1 的原因是题目说是小于n的质数个数，并不包括n。 然后来实现埃拉托斯特尼筛法
     * @param n
     * @return
     */
    public static int countPrimes(int n) {

        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                res++;
                // 将i的2倍、3倍、4倍...都标记为非素数
                for (int j = i * 2; j < n; j = j + i) {
                    prime[j] = false;
                }
            } else {
                continue;
            }
        }
        return res;
    }
}
