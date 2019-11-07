/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structure.TreeNode;

/**
 *107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author tangyue
 * @version $Id: BinaryTreeLevelOrderTraversalII.java, v 0.1 2019-07-09 11:08 tangyue Exp $$
 */
public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {

        System.out.println(levelOrderBottom(TreeNode.createTestData("[]")));
        System.out.println(levelOrderBottom(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
        System.out.println(levelOrderBottom(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));

        System.out.println("============================");
        System.out.println(levelOrderBottom1(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = queue.size();// 记录每层的节点个数
        TreeNode temp;
        List<Integer> singleLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (i == 0) { // 一层记录结束
                result.addFirst(singleLevel);
                i = queue.size();
                singleLevel = new ArrayList<>();
            }
            temp = queue.poll();
            singleLevel.add(temp.val);
            --i;

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        result.addFirst(singleLevel);
        return result;
    }


    public static List<List<Integer>> levelOrderBottom1(TreeNode root){
        LinkedList<List<Integer>> result = new LinkedList<>();
        levelRecursion(root, result, 0);
        return result;
    }

    /**
     *
     * @param node
     * @param result
     * @param level 标记深度
     */
    private static void levelRecursion(TreeNode node, LinkedList<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        int l = level + 1;
        // 节点不为空,新增一个新的节点,然后赋值
        if (result.size() < l) { // 说明还需要添加一行
            result.addFirst(new ArrayList<>());
        }
        result.get(result.size() - l).add(node.val);

        levelRecursion(node.left, result, l);
        levelRecursion(node.right, result, l);
    }
}
