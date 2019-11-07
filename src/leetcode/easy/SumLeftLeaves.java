/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import structure.TreeNode;

/**
 * 404. Sum of Left Leaves
 *Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * @author tangyue
 * @version $Id: SumLeftLeaves.java, v 0.1 2019-09-19 15:19 tangyue Exp $$
 */
public class SumLeftLeaves {

    public static void main(String[] args) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {

        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }


}
