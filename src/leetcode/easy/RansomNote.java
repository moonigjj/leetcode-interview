/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 383. Ransom Note
 *Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * @author tangyue
 * @version $Id: RansomNote.java, v 0.1 2019-09-17 13:36 tangyue Exp $$
 */
public class RansomNote {

    public static void main(String[] args) {

        System.out.println(canConstruct("aa", "aab"));
    }

    /**
     * 列出了magazine的字母表，然后算出了出现个数，然后遍历ransomNote，保证有足够的字母可用
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] temp = new int[26];
        for (int i = 0, len = magazine.length(); i < len; i++){
            temp[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0, len = ransomNote.length(); i < len; i++) {
            if (--temp[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
