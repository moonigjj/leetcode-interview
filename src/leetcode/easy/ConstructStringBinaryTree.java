package leetcode.easy;

import structure.TreeNode;

import java.util.Objects;

/**
 * 606. Construct String from Binary Tree
 * Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4]
 * Output: "1(2(4))(3)"
 * Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4]
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 * @auTHOR TangYue
 * @date 2023/6/7
 */
public class ConstructStringBinaryTree {

    public static void main(String[] args) {
        TreeNode testData = TreeNode.createTestData("[1,2,3,null,4]");
        System.out.println(tree2str(testData));
    }



    public static String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        deepRoot(root, sb);
        return sb.toString();
    }

    public static void deepRoot(TreeNode root, StringBuffer sb) {
        if (root == null){
            return;
        }
        sb.append(root.val);
        if (root.right != null){
            // if the right child isn't empty, we still need to append '()' although the left child is empty
            deepRoot(root.left, sb.append("("));
            sb.append(")");
            deepRoot(root.right, sb.append("("));
            sb.append(")");
        } else if (root.left != null){
            deepRoot(root.left, sb.append("("));
            sb.append(")");
        }
    }
}
