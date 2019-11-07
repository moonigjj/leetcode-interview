/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 *409. Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * @author tangyue
 * @version $Id: LongestPalindrome.java, v 0.1 2019-10-18 9:37 tangyue Exp $$
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abcccc"));
    }

    public static int longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) {
                lowercase[temp-'a']++;
            }
            else {
                uppercase[temp-'A']++;
            }
        }
        for (int i = 0; i < 26; i++){
            res+=(lowercase[i]/2)*2;
            res+=(uppercase[i]/2)*2;
        }
        // 长度不等，必有奇数
        return res == s.length() ? res : res+1;
    }
}
