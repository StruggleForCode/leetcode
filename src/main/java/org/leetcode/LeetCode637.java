package org.leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: LeetCode637
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/20 22:41
 * @Version 1.0
 */
public class LeetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.#####");
        queue.offer(root);
        int lastLen = 1;
        int len = 1;
        double sum = 0;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            sum += curNode.val;
            len--;
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
            if (len == 0) {
                double avg = sum / lastLen;
                res.add(Double.valueOf(df.format(avg)));
                len = queue.size();
                lastLen = len;
                sum = 0;
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
