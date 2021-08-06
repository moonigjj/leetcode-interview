package leetcode.easy;

import structure.TreeNode;

import java.util.Objects;

/**
 * 543. Diameter of Binary Tree
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 */
public class DiameterBinaryTree {

    int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        longestPath((root));
        return maxLength;
    }

    private int longestPath(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }

        int leftLength = longestPath(node.left);
        int rightLength = longestPath(node.right);

        int currentSum = leftLength + rightLength;
        maxLength = (currentSum > maxLength) ? currentSum : maxLength;
        return Math.max(leftLength, rightLength) + 1;
    }

    public static void main(String[] args) {

    }
}
