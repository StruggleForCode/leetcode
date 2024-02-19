package org.leetcode;

/**
 * ClassName: LeetCode114
 * Package: org.leetcode
 * Description: 递归的精髓就在于把大范围 小范围话，尝试几个节点是否可以，然后在考虑全局，还需要找到临界点
 *
 * @Author LeeHao
 * @Create 2024/2/19 21:56
 * @Version 1.0
 */
public class LeetCode114 {

    // 后序遍历，先遍历右节点
    public void flatten(TreeNode root) {
       postTree(root);
    }

    public TreeNode postTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 后序遍历，先遍历右节点,在遍历左节点
        TreeNode rightNode = postTree(root.right);
        TreeNode leftNode = postTree(root.left);
        if (leftNode != null) {
            TreeNode temp = leftNode;
            // 找到左节点的最右边的节点，然后右边节点为 rightNode
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            leftNode.right = rightNode;
            root.right = temp;
        }
        // 把左节点至为空
        root.left = null;
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
