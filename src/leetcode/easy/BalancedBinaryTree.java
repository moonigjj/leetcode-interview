/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import structure.TreeNode;

/**
 * 110. Balanced Binary Tree
 *Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * @author tangyue
 * @version $Id: BalancedBinaryTree.java, v 0.1 2019-07-17 11:21 tangyue Exp $$
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode testData = TreeNode.createTestData("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]");
        System.out.println(isBalanced(testData));
        System.out.println(isBalanced1(testData));
    }

    /**
     * 求二叉树是否平衡，根据题目中的定义，高度平衡二叉树是每一个结点的两个子树的深度差不能超过1，
     * 那么我们肯定需要一个求各个点深度的函数，然后对每个节点的两个子树来比较深度差，时间复杂度为O(NlgN)
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取深度
     * @param node
     * @return
     */
    private static int getDepth(TreeNode node) {
        if (node == null){
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    /**
     * 上面那个方法正确但不是很高效，因为每一个点都会被上面的点计算深度时访问一次，我们可以进行优化。
     * 方法是如果我们发现子树不平衡，则不计算具体的深度，而是直接返回-1。那么优化后的方法为：对于每一个节点，
     * 我们通过checkDepth方法递归获得左右子树的深度，
     * 如果子树是平衡的，则返回真实的深度，若不平衡，直接返回-1，此方法时间复杂度O(N)，空间复杂度O(H)
     * @param root
     * @return
     */
    public static boolean isBalanced1(TreeNode root) {
        if (checkDepth(root) == -1){
            return false;
        } else {
            return true;
        }
    }

    private static int checkDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = checkDepth(node.left);
        if (left == -1) {
            return -1;
        }
        int right = checkDepth(node.right);
        if (right == -1) {
            return -1;
        }
        int diff = Math.abs(left - right);
        if (diff > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }
}
