/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 *443. String Compression
 * Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the original array.
 *
 * Every element of the array should be a character (not int) of length 1.
 *
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input:
 * ["a","a","b","b","c","c","c"]
 *
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 *
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * @author tangyue
 * @version $Id: StringCompression.java, v 0.1 2019-11-27 11:08 tangyue Exp $$
 */
public class StringCompression {

    public static void main(String[] args) {

        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
        System.out.println(compress(new char[]{'a'}));
    }

    /**
     * 快慢指针，值不相等，slow变成fast值
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        int len = chars.length;
        int slow = 0;
        int fast = 0;
        while (fast < len){
            int count = 0;
            char cur = chars[fast];
            // 快指针长度小于数组长度，并且
            while (fast < len && cur == chars[fast]){
                count++;
                fast++;
            }
            //相等的快指针的值赋给慢指针
            chars[slow++] = cur;
            // 数字重新赋值，慢指针向前
            if (count != 1){
                for (char c : Integer.toString(count).toCharArray()){
                    chars[slow++] = c;
                }
            }
        }
        return slow;
    }

}
