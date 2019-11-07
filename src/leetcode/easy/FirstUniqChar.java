/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 *387. First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * @author tangyue
 * @version $Id: FirstUniqChar.java, v 0.1 2019-09-17 13:46 tangyue Exp $$
 */
public class FirstUniqChar {

    public static void main(String[] args) {

        System.out.println(firstUniqChar("loveleetcode"));
    }

    /**
     * 解法一
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {

        int[] temp = new int[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            temp[s.charAt(i) - 'a']++;
        }

        for (int i = 0, len = s.length(); i < len; i++) {
            if (temp[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
