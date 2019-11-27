/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.HashMap;

import structure.TreeNode;

/**
 * 437. Path Sum III
 *You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * @author tangyue
 * @version $Id: PathSumIII.java, v 0.1 2019-11-04 17:35 tangyue Exp $$
 */
public class PathSumIII {

    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int sum) {

        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    /**
     * 用hash表记录当前遍历路径中的子路径权值和对应出现的次数。
     *
     * 若sum为从根节点到某x节点的路径权值和，则遍历至节点x时，当前的路径和curSum恰好与sum相等，则res = m[curSum - sum] = m[0] = 1;
     * 若sum为某段子路径权值和，如：x1->x2->x3->x4......中sum等于节点x3与节点x4的权值和，即sum = sumx3+x4。
     * 则遍历至x2时， m[curSum]++; 处已经记录了m[curSum] = m[sumx1+x2] = 1,
     * 遍历至x4时curSum = sumx1+x2+x3+x4,则res = m[curSum - sum] = m[sumx1+x2+x3+x4 - sumx3+x4] = m[sumx1+x2] = 1。
     * @param root
     * @param currSum
     * @param target
     * @param preSum
     * @return
     */
    private static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }


    public static int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
    }

    public static int findPath(TreeNode root, int sum){
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.val == sum) {
            res++;
        }

        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

}
