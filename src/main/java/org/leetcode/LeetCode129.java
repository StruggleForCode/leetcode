package org.leetcode;

/**
 * ClassName: LeetCode129
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/20 22:02
 * @Version 1.0
 */
public class LeetCode129 {
    private int sumValue;
    public int sumNumbers(TreeNode root) {
        this.sumValue = 0;
        if (root == null) return 0;
        deepTree(root, "");
        return sumValue;
    }

    public void deepTree(TreeNode root, String value) {
        if (root.left == null && root.right == null) {
            sumValue += Integer.valueOf(value + String.valueOf(root.val));
            return;
        }
        if (root.left != null) {
            deepTree(root.left, value + String.valueOf(root.val));
        }
        if (root.right != null) {
            deepTree(root.right, value + String.valueOf(root.val));
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
