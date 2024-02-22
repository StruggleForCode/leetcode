package org.leetcode;

import java.util.Stack;

/**
 * ClassName: LeetCode26
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/22 22:13
 * @Version 1.0
 */
public class LeetCode236 {
    private Stack<TreeNode> stack;

    // 自己写的没做出来。。
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            if (curNode == p || curNode == q) {
                break;
            }
            if (curNode.left == null && curNode.right == null) {
                continue;
            }
            stack.push(curNode);
            if (curNode.left != null) {
                stack.push(curNode.left);
            } else if (curNode.right != null) {
                stack.push(curNode.right);
            }
         }
        TreeNode temp = stack.peek();
        TreeNode findNode;
        findNode = temp == q ? p : q;
        TreeNode resNode = temp;
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            if (curNode == findNode) {

            }
            if (curNode.left == null && curNode.right == null) {
                continue;
            }
            stack.push(curNode);
        }
        return resNode;
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
