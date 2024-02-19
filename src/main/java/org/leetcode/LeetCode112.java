package org.leetcode;

/**
 * ClassName: LeetCode112
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/19 22:48
 * @Version 1.0
 */
public class LeetCode112 {
    boolean ok;
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ok = false;
        this.targetSum = targetSum;
        preTree(root, 0);
        return ok;
    }

    public void preTree(TreeNode root, int sum) {
        if (ok) {
            return;
        }
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            ok = true;
            return;
        }
        preTree(root.left, sum);
        preTree(root.right, sum);
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
