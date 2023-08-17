package leetcode.easy;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**653. Two Sum IV - Input is a BST
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 * @auTHOR TangYue
 * @date 2023/6/28
 */
public class TwoSumBST {

    public static void main(String[] args) {
        System.out.println(findTarget(TreeNode.createTestData("[5,3,6,2,4,null,7]"), 28));
    }

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        return findTargetDFS(root, k, list);
    }

    public static boolean findTargetDFS(TreeNode root, int k, List<Integer> list){
        if (root == null){
            return false;
        }
        int val = root.val;
        int diff = k - val;
        if (list.contains(diff)){
            return true;
        }
        list.add(val);
        return findTargetDFS(root.left, k, list) || findTargetDFS(root.right, k, list);
    }
}
