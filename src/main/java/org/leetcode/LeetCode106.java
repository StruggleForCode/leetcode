package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode106
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/18 21:34
 * @Version 1.0
 */
public class LeetCode106 {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    Map<Integer, Integer> postorderMap = new HashMap<>();

    @Test
    public void test() {
        int[] inorder = {11, 9, 12, 3, 8, 15, 20, 7};
        int[] postorder = {11, 12, 9, 8, 15, 7, 20, 3};
        buildTree(inorder, postorder);
    }

    /**
     * 瞎几把写，居然过了
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
            postorderMap.put(postorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inorderBegin, int inorderEnd, int postorderBegin, int postorderEnd) {
        if (inorderBegin > inorderEnd || postorderBegin > postorderEnd) {
            return null;
        }
        int root = postorder[postorderEnd];
        // 对于左子树
        // inorderBegin 为 inorderBegin开始长度
        // inorderEnd 为 inorderMap.get(root)
        // postorderBegin 为 postorderBegin 开始长度
        // postorderEnd 的值为 postorderBegin开始值，加上左子输的长度（inorderMap.get(root) - inorderBegin）- 1，好难理解
        TreeNode leftNode = build(inorder, postorder, inorderBegin, inorderMap.get(root), postorderBegin, postorderBegin + inorderMap.get(root) - inorderBegin - 1);
        // 对于右子树
        // inorderBegin 为 inorderMap.get(root) + 1
        // inorderEnd 为 inorderEnd
        // postorderBegin 的值为 postorderBegin开始值，加上左子输的长度，好难理解
        // postorderEnd 的值为  root下标减一
        TreeNode rightNode = build(inorder, postorder, inorderMap.get(root) + 1, inorderEnd, postorderBegin + inorderMap.get(root) - inorderBegin, postorderMap.get(root) - 1);
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
