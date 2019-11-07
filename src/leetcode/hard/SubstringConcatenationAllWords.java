/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 *You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * @author tangyue
 * @version $Id: SubstringConcatenationAllWords.java, v 0.1 2019-06-18 13:44 tangyue Exp $$
 */
public class SubstringConcatenationAllWords {

    public static void main(String[] args) {

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0){
            return null;
        }
        int size = s.length();
        int len = words[0].length();
        List<Integer> list = new ArrayList<>();
        if (size < len){
            return list;
        }
        return list;
    }
}
