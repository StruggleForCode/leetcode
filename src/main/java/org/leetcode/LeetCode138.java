package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode138
 * Package: org.leetcode
 * Description:
 * 本人用了两个Map集合，看了题解，其实两个map可以合成一个Map
 * 题解二中还有一种不需要用到map到方法也很巧妙，O(1)的空间复杂度
 *
 * @Author LeeHao
 * @Create 2024/2/3 21:49
 * @Version 1.0
 */
public class LeetCode138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node res = new Node(head.val);
        Map<Node, Integer> nodeIntegerMap = new HashMap<>();
        Map<Integer, Node> integerNodeMap = new HashMap<>();
        Node ptr = head;
        Node ptr2 = res;
        int index = 1;
        while (ptr.next != null) {
            nodeIntegerMap.put(ptr, index);
            integerNodeMap.put(index, ptr2);
            index++;
            ptr = ptr.next;
            Node tmp = new Node(ptr.val);
            ptr2.next = tmp;
            ptr2 = tmp;
        }
        nodeIntegerMap.put(ptr, index);
        integerNodeMap.put(index, ptr2);
        ptr = head;
        ptr2 = res;
        while (ptr != null) {
            if (ptr.random != null) {
                index = nodeIntegerMap.get(ptr.random);
                ptr2.random = integerNodeMap.get(index);
            }
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
