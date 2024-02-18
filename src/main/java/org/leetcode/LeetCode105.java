package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ClassName: LeetCode105
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/18 21:32
 * @Version 1.0
 */
public class LeetCode105 {
    /**
     瞎几把写，居然过了
     */
    @Test
    public void test() {
        // int[] preorder = {3,9,20,15,7};
        // int[] inorder = {9,3,15,20,7};
        int[] preorder = {3, 9, 11, 12, 20, 15, 8, 7};
        int[] inorder = {11, 9, 12, 3, 8, 15, 20, 7};
        buildTree(preorder, inorder);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root) {
                break;
            }
        }
        TreeNode leftNode = buildTree(Arrays.copyOfRange(preorder, 1, preorder.length), Arrays.copyOfRange(inorder, 0, i));
        TreeNode rightNode = null;
        if (i + 1 < inorder.length) {
            rightNode = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
        }
        return new TreeNode(root, leftNode, rightNode);
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
