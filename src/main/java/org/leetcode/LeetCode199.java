package org.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: LeetCode199
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/22 22:48
 * @Version 1.0
 */
public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);
        int len = 1;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            len--;
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
            if (len == 0) {
                res.add(curNode.val);
                len = queue.size();
            }
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
