/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import structure.Node;

/**
 * 429. N-ary Tree Level Order Traversal
 *Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * We should return its level order traversal:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * @author tangyue
 * @version $Id: NaryTreeLevelOrderTraversal.java, v 0.1 2019-10-25 10:15 tangyue Exp $$
 */
public class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> lists = new ArrayList<>();
        helper(root, 0, lists);
        return lists;
    }

    private static List<List<Integer>> helper(Node root, int level, List<List<Integer>> lists) {
        if (root == null) {
            return lists;
        }

        if (lists.size() == level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        for (Node n : root.children) {
            helper(n, level + 1, lists);
        }
        return lists;
    }
}
