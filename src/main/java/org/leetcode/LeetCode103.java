package org.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: LeetCode103
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/22 23:13
 * @Version 1.0
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        deque.addFirst(root);
        int deep = 1;
        int len = 1;
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (len != 0) {
                TreeNode curNode = null;
                if (deep % 2 == 1) {
                    curNode = deque.pollFirst();
                    if (curNode.left != null) {
                        deque.addLast(curNode.left);
                    }
                    if (curNode.right != null) {
                        deque.addLast(curNode.right);
                    }
                }
                if (deep % 2 == 0) {
                    curNode = deque.pollLast();
                    if (curNode.right != null) {
                        deque.addFirst(curNode.right);
                    }
                    if (curNode.left != null) {
                        deque.addFirst(curNode.left);
                    }
                }
                len--;
                temp.add(curNode.val);
            }
            deep++;
            len = deque.size();
            res.add(temp);
        }
        return res;
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
