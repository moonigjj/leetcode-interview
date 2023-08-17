package leetcode.easy;

import structure.TreeNode;

import java.util.*;

/**
 * 637. Average of Levels in Binary Tree
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * @auTHOR TangYue
 * @date 2023/6/25
 */
public class AverageLevelsBinaryTree {

    public static void main(String[] args) {

        System.out.println(averageOfLevels(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }

    private static final Map<Integer, Double> map = new HashMap<>();

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++){
                TreeNode x = queue.poll();
                sum += x.val;
                if (x.left != null){
                    queue.add(x.left);
                }
                if (x.right != null){
                    queue.add(x.right);
                }
            }
            list.add(sum / n);
        }
        return list;
    }


    public void avg(TreeNode root){

    }

}
