/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import structure.TreeNode;

/**
 *
 * @author tangyue
 * @version $Id: BinaryTreePaths.java, v 0.1 2019-08-30 13:46 tangyue Exp $$
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

        System.out.println(binaryTreePaths(TreeNode.createTestData("[]")));
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new ArrayList<>();
        if (root != null) {
            helper(list, "", root);
        }
        return list;
    }

    public static void helper(List<String> list, String s, TreeNode node) {

        s = s + node.val;
        if (node.left == null && node.right == null){
            list.add(s);
            return;
        }
        if (node.left != null) {
            helper(list, s + "->", node.left);
        }
        if (node.right != null) {
            helper(list, s + "->", node.right);
        }
    }
}
