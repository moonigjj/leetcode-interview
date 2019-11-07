/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 *
 * @author tangyue
 * @version $Id: ValidAnagram.java, v 0.1 2019-08-30 9:54 tangyue Exp $$
 */
public class ValidAnagram {

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram1("anagram", "nagaram"));
        // System.out.println(isAnagram2("rat", "tar"));
    }

    /**
     * 排序后判相等
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);

        String ss = new String(s1);
        String ts = new String(t1);
        return ss.equals(ts);
    }

    /**
     * 计数判相等
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {

        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            temp[index]--;
        }

        for (int i : temp) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /*public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum ^= s.charAt(i) ^ t.charAt(i);
        }
        return sum == 0 ? true : false;
    }*/
}
