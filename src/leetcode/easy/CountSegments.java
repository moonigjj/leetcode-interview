/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 434. Number of Segments in a String
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 * @author tangyue
 * @version $Id: CountSegments.java, v 0.1 2019-10-30 10:42 tangyue Exp $$
 */
public class CountSegments {

    public static void main(String[] args) {

        System.out.println(countSegments("Hello, my name is John"));
        System.out.println('Z' - 'A');
    }

    public static int countSegments(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int temp = s.charAt(i);
            if (temp != ' ') {
                count++;
                i++;
                while (i < len && s.charAt(i) != ' ') {
                    i++;
                }
            }
        }
        return count;
    }
}
