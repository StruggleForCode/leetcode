package org.leetcode;

import java.io.StringReader;

/**
 * ClassName: LeetCode101
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/17 22:06
 * @Version 1.0
 */
public class LeetCode101 {
    /**
     * 瞎几把写，居然过了，何德何能，居然和官方写法一样
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return deepSymmetric(root.left, root.right);
    }

    public boolean deepSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode != null && rightNode == null) {
            return false;
        }
        if (leftNode == null && rightNode != null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return deepSymmetric(leftNode.left, rightNode.right) & deepSymmetric(leftNode.right, rightNode.left);
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
