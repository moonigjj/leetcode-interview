/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 *Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * @author tangyue
 * @version $Id: WordPattern.java, v 0.1 2019-09-04 10:09 tangyue Exp $$
 */
public class WordPattern {

    public static void main(String[] args) {

        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }


    /**
     * 建立模式字符串中每个字符和单词字符串每个单词之间的映射，而且这种映射必须是一对一关系的，
     * 不能 'a' 和 'b' 同时对应 'dog'，也不能 'a' 同时对应到 'dog' 和 'cat'，
     * 所以我们在碰到一个新字符时，首先检查其是否在 HashMap 中出现，若出现，
     * 其映射的单词若不是此时对应的单词，则返回 false。如果没有在 HashMap 中出现，
     * 我们还要遍历一遍 HashMap，看新遇到的单词是否已经是其中的映射，若已经有其他映射，
     * 直接返回 false，如果没有，再跟新遇到的字符建立映射。最后循环退出后，要检查此时的 i 是否和 n 相同，
     * 这是检查一对一映射的最后一步，因为当 str 中的单词处理完了之后，pattern 中就不能有多余的字符了
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {

        int len = pattern.length();
        String[] strs = str.split(" ");
        if (len != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(pattern.charAt(i))) {

                if (!map.get(pattern.charAt(i)).equals(strs[i])){
                    return false;
                }
            } else {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }

}
