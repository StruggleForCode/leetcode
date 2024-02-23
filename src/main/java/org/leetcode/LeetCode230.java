package org.leetcode;

/**
 * ClassName: LeetCode230
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/23 21:38
 * @Version 1.0
 */
public class LeetCode230 {
    private int count;

    private boolean ok;

    private int ans;

    public int kthSmallest(TreeNode root, int k) {
        ok = false;
        count = k;
        deepTree(root);
        return ans;
    }

    public void deepTree(TreeNode root) {
        if (ok || root == null) {
            return;
        }
        deepTree(root.left);
        count--;
        if (count == 0) {
            ans = root.val;
            ok = true;
        }
        deepTree(root.right);
    }
}
