package org.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCodeOffer55_2 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        int depth = 1;
        int len = 1;
        int minDepth = -1;
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode cur = treeNodeQueue.poll();
            len--;
            if (cur.left != null) {
                treeNodeQueue.offer(cur.left);
            }
            if (cur.right != null) {
                treeNodeQueue.offer(cur.right);
            }
            if (minDepth != -1 && cur.left == null && cur.right == null) {
                minDepth = depth;
            }
            if (len == 0 && treeNodeQueue.size() != 0) {
                len = treeNodeQueue.size();
                depth++;
                if (depth - minDepth >= 2) return false;
            }
        }
        return (depth - minDepth) >=2 ? false : true;
    }
}
