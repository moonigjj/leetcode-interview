/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import structure.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * @author tangyue
 * @version $Id: LowestCommonAncestorBinarySearchTree.java, v 0.1 2019-08-26 10:52 tangyue Exp $$
 */
public class LowestCommonAncestorBinarySearchTree {

    public static void main(String[] args) {

        TreeNode.print(lowestCommonAncestor(
                TreeNode.createTestData("[6,2,8,0,4,7,9,null,null,3,5]"),
                TreeNode.createTestData("[2]"),
                TreeNode.createTestData("[8]")
                ));
    }

    /**
     * 递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return (root.val - p.val) * (root.val - q.val) < 1 ? root :
                lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }

    /**
     * 迭代
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
