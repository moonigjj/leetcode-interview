/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author tangyue
 * @version $Id: GenerateParentheses.java, v 0.1 2019-05-08 14:45 tangyue Exp $$
 */
public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    /**
     * backtracking（回溯算法）
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        helper(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    private static void helper(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (left == n && right == n){
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            helper(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        // System.out.println("left: " + left + ", right: " + right);
        if (right < left) {
            sb.append(")");
            helper(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
