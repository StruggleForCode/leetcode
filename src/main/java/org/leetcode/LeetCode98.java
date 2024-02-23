package org.leetcode;

/**
 * ClassName: LeetCode98
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/23 21:39
 * @Version 1.0
 */
public class LeetCode98 {
    private boolean ok;
    private long lastValue;


    public boolean isValidBST(TreeNode root) {
        ok = true;
        if (root == null) {
            return ok;
        }
        if (root.left == null && root.right == null) {
            return ok;
        }
        TreeNode temp = root;
        lastValue = Long.MIN_VALUE;
        deepTree(root);
        return ok;
    }

    public void deepTree(TreeNode root) {
        if (!ok || root == null) {
            return;
        }
        deepTree(root.left);
        if (lastValue >= root.val) {
            ok = false;
        }
        lastValue = root.val;
        deepTree(root.right);
    }
}
