/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 * 205. Isomorphic Strings
 *Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * @author tangyue
 * @version $Id: IsomorphicStrings.java, v 0.1 2019-08-22 10:16 tangyue Exp $$
 */
public class IsomorphicStrings {

    public static void main(String[] args) {

        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic1("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] tmp = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (tmp[s.charAt(i)] != tmp[t.charAt(i) + 256]) {
                return false;
            }
            tmp[s.charAt(i)] = tmp[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
    public static boolean isIsomorphic1(String s, String t) {

        int[] si = new int[256];
        int[] ti = new int[256];
        Arrays.fill(si, -1);
        Arrays.fill(ti, -1);

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (si[s.charAt(i)] != ti[t.charAt(i)]) {
                return false;
            }
            si[s.charAt(i)] = ti[t.charAt(i)] = i;
        }
        return true;
    }

}
