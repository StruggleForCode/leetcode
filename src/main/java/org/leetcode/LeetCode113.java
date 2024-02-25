package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ClassName: LeetCode113
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/25 22:09
 * @Version 1.0
 */
public class LeetCode113 {

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> nodes1 = new ArrayList<>();
        nodes1.add(node2);
        nodes1.add(node4);
        node1.neighbors = nodes1;
        node3.neighbors = nodes1;
        List<Node> nodes2 = new ArrayList<>();
        nodes2.add(node1);
        nodes2.add(node3);
        node2.neighbors = nodes2;
        node4.neighbors = nodes2;
        Node res = cloneGraph(node1);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        boolean[] flag = new boolean[105];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = false;
        }
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            flag[curNode.val] = true;
            List<Node> neighbors = new ArrayList<>();
            for (int i = 0; i < curNode.neighbors.size(); i++) {
                Node curNeighbor = curNode.neighbors.get(i);
                if (!flag[curNeighbor.val]) {
                    queue.offer(curNeighbor);
                }
                Node curNeighbor1 = null;
                if (nodeMap.containsKey(curNeighbor.val)) {
                    curNeighbor1 = nodeMap.get(curNeighbor.val);
                } else {
                    curNeighbor1 = new Node(curNeighbor.val);
                    nodeMap.put(curNeighbor1.val, curNeighbor1);
                }
                neighbors.add(curNeighbor1);
            }
            Node curNodeCopy = nodeMap.containsKey(curNode.val) ? nodeMap.get(curNode.val) : new Node(curNode.val);
            curNodeCopy.neighbors =  neighbors;
            nodeMap.put(curNodeCopy.val, curNodeCopy);
        }
        return nodeMap.get(node.val);
    }


    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
