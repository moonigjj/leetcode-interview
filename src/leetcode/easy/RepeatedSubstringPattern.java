package leetcode.easy;

/**
 * 459. Repeated Substring Pattern
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("a"));
    }

    /**
     *输入字符串的第一个字符串是重复子字符串的第一个字符
     *
     * 输入字符串的最后一个字符串是重复子字符串的最后一个字符
     *
     * 令S1 = S + S（其中输入字符串中的S）
     *
     * 删除S1的第一个和最后一个字符，生成字符串S2。
     *
     * 如果S存在于S2中，则返回true否则为false。
     *
     * 这个思想的精髓就在于通过拷贝一次字符串，并且各自破坏一小部分，然后通过两个串的拼接完成原串的查找。如果串不满足要求的特性，是拼装不出来的。
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        String sb = (s + s).substring(1, 2 * len - 1);
        return sb.contains(s);
    }
}
