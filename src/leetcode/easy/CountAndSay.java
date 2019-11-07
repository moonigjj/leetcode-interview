/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 38. Count and Say
 *The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string
 * @author tangyue
 * @version $Id: CountAndSay.java, v 0.1 2019-07-08 10:05 tangyue Exp $$
 */
public class CountAndSay {

    public static void main(String[] args) {

        System.out.println(countAndSay(5));
        System.out.println(countAndSay1(1));
    }

    /**
     * 递归 输出上个字符的组合
     * @param n
     * @return
     */
    public static String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        // String res = countAndSay(n - 1) + "*";
        // 如果不考虑对原有字符串的破坏，加一个分割字符来统计循环计数会简单很多
        /**
         * StringBuilder s = new StringBuilder();
         *         for (int i = 0; i < len - 1; i++){
         *             // 如果邻近的一位相等，计数加一
         *             if (c[i] == c[i + 1]) {
         *                 count++;
         *             } else {
         *                 s.append(count).append(c[i]);
         *
         *                 count = 1;
         *             }
         *         }
         */
        String res = countAndSay(n - 1);
        char[] c = res.toCharArray();
        int len = c.length;
        int count = 1;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++){
            // 如果邻近的一位相等，计数加一
            if (i + 1 < len && c[i] == c[i + 1]) {
                count++;
            } else {
                s.append(count).append(c[i]);

                count = 1;
            }
        }
        return s.toString();
    }

    // 迭代
    public  static String countAndSay1(int n) {

        String str = "1";
        while (--n > 0){
            int count = 1;
            StringBuilder s = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++){
                // 如果邻近的一位相等，计数加一
                if (i + 1 < len && chars[i] == chars[i + 1]) {
                    count++;
                } else {
                    s.append(count).append(chars[i]);
                    count = 1;
                }
            }
            str = s.toString();
        }
        return str;
    }

}
