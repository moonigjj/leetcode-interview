/**
 * chenxitech.cn Inc. Copyright (c) 2017-2018 All Rights Reserved.
 */
package airbnb;

import structure.TreeNode;

/**
 *
 * @author tangyue
 * @version $Id: ConvertSortedArrayToBinarySearchTree.java, v 0.1 2018-11-20 16:01 tangyue Exp $$
 */
public class ConvertSortedArrayToBinarySearchTree {

    // Given an array where elements are sorted in ascending order,
    // convert it to a height balanced BST.
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 数组递归生成平衡二叉树
     * @param nums 数组
     * @param start 起始
     * @param end 结束
     * @return
     */
    private static TreeNode helper(int[] nums, int start, int end) {
        if(start <= end) {

            int mid = (start + end) / 2;
            TreeNode current = new TreeNode(nums[mid]);
            current.left = helper(nums, start, mid - 1);
            current.right = helper(nums, mid + 1, end);
            return current;
        }
        return null;
    }
}
