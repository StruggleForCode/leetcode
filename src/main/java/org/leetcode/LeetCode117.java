package org.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: LeetCode117
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/19 12:51
 * @Version 1.0
 */
public class LeetCode117 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return null;
        queue.offer(root);
        int len = 1;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
            len--;
            if (len == 0) {
                curNode.next = null;
                len = queue.size();
                continue;
            }
            curNode.next = queue.peek();
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

