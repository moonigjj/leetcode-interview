/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 345. Reverse Vowels of a String
 *Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * @author tangyue
 * @version $Id: ReverseVowels.java, v 0.1 2019-09-09 11:10 tangyue Exp $$
 */
public class ReverseVowels {

    public static void main(String[] args) {

        System.out.println(reverseVowels("hello"));
    }

    /**
     * 迭代字符串的元素，找到第n个元音字母后，就尝试去找第len-1-n个元音字母，如果找到就交换位置，再进入下一次循环迭代；
     * 如果没找到，则退出循环。代码很像快速排序中处理第n个和第len-1-n个元素的方式
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        String vowels = "aoeiuAOEIU";
        char[] sc = s.toCharArray();
        int len = sc.length;
        int i = 0;
        int j = len - i - 1;
        while (i < j) {
            while (i < j && !vowels.contains(sc[i] + "")) {
                i++;
            }
            while (i < j && !vowels.contains(sc[j] + "")) {
                j--;
            }

            if (i < j) {
                char tmp = sc[i];
                sc[i++] = sc[j];
                sc[j--] = tmp;
            }
        }

        return new String(sc);
    }
}
