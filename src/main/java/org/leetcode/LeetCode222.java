package org.leetcode;

/**
 * ClassName: LeetCode222
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/20 22:33
 * @Version 1.0
 */
public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 1;
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
            high++;
        }
        int minCount = (int) Math.pow(2, high - 1);
        int maxCount = (int) Math.pow(2, high) - 1;
        int left = minCount;
        int right = maxCount;
        int mid = left;
        while (left < right) {
            mid = (right - left + 1) / 2 + left;
            temp = root;
            if (findNode(temp, mid, high)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return mid;
    }

    public boolean findNode(TreeNode root, int target, int high) {
        int bits = 1 << (high - 2);
        while (root != null && bits > 0) {
            if ((target & bits) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            bits = bits >> 1;
        }
        return root != null;
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
