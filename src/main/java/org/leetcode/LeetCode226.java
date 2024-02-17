package org.leetcode;

/**
 * ClassName: LeetCode226
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/17 21:45
 * @Version 1.0
 */
public class LeetCode226 {

    /**
     * 瞎几把写居然过了
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        } else if (root.left == null && root.right !=null) {
            root.left = root.right;
            root.right = null;
        } else if (root.left != null && root.right != null) {
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
        }
        return root;
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
