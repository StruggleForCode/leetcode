package org.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: LeetCode102
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/22 22:59
 * @Version 1.0
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);
        int len = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (len != 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                temp.add(curNode.val);
                len--;
            }
            len = queue.size();
            if (temp.size() > 0) {
                res.add(temp);
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
