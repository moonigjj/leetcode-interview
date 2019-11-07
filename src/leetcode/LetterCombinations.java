/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * @author tangyue
 * @version $Id: LetterCombinations.java, v 0.1 2019-03-22 13:18 tangyue Exp $$
 */
public class LetterCombinations {

    public static void main(String[] args) {

        System.out.println(letterCombinations("2"));
    }

    /**
     * backtracking（回溯算法）
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int len = digits.length();
        if (len < 1) {
            return list;
        }
        String[] table = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // index从0开始，即digits的第一个数字
        letterCombinations(list, digits, "", 0 , table);
        return list;
    }

    private static void letterCombinations(List<String> list, String digits,
                                     String curr, int index,String[] table) {
        // 最后一层退出条件
        if (index == digits.length()) {
            if (curr.length() != 0) {
                list.add(curr);
            }
            return;
        }

        // 找到数字对应的字符串
        String temp = table[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            // 每次循环把不同字符串加到当前curr之后
            String next = curr + temp.charAt(i);
            // 进入下一层
            letterCombinations(list, digits, next, index + 1, table);
        }
    }
}
