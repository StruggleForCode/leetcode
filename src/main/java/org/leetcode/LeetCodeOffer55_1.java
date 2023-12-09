package org.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCodeOffer55_1 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        int depth = 1;
        int len = 1;
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
            if (len == 0 && treeNodeQueue.size() != 0) {
                len = treeNodeQueue.size();
                depth++;
            }
        }
        return depth;
    }

}
