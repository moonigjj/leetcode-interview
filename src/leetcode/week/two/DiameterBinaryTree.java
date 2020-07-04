package leetcode.week.two;

import structure.TreeNode;

/**
 * Diameter of Binary Tree
 *
 * Solution
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterBinaryTree {

    public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root) {

        int maxDeep = 0;
        maxDeep(root, maxDeep);
        return maxDeep;
    }

    private static int maxDeep(TreeNode root, int maxDeep){
        if (root == null){
            return 0;
        }
        int left = maxDeep(root.left, maxDeep);
        int right = maxDeep(root.right, maxDeep);
        maxDeep = Math.max(maxDeep, left + right);
        return Math.max(left, right) + 1;
    }
}
