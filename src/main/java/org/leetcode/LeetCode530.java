package org.leetcode;

/**
 * ClassName: LeetCode530
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/23 21:38
 * @Version 1.0
 */
public class LeetCode530 {
    private int minSize;
    private int lastValue;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minSize = 1000001;
        lastValue = root.val + minSize;
        deepTree(root);
        return minSize;
    }

    public void deepTree(TreeNode root) {
        if (root == null) {
            return;
        }
        deepTree(root.left);
        if (Math.abs(lastValue - root.val) < minSize) {
            minSize = Math.abs(lastValue - root.val);
        }
        lastValue = root.val;
        deepTree(root.right);
    }
}
