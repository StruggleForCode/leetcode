package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode146
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/5 20:21
 * @Version 1.0
 */
public class LeetCode146 {

    class BiLinkList {
        int key;
        int value;
        BiLinkList next;
        BiLinkList prev;
        BiLinkList(){}
        BiLinkList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    BiLinkList head;
    BiLinkList tail;

    private Map<Integer, BiLinkList> cache;

    public LeetCode146(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new BiLinkList();
        tail = new BiLinkList();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        BiLinkList curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        removeNode(curNode);
        addNode(head, curNode);
        return curNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        BiLinkList curNode = cache.get(key);
        // 如果包含
        if (curNode != null) {
            removeNode(curNode);
            addNode(head, curNode);
            curNode.value = value;
            return;
        }
        // 如果容量不够，移除最后一个节点
        if (cache.size() == capacity) {
            BiLinkList lastNode = tail.prev;
            removeNode(lastNode);
            cache.remove(lastNode.key);
        }
        BiLinkList biLinkList = new BiLinkList(key, value);
        addNode(head, biLinkList);
        cache.put(key, biLinkList);
    }

    private void removeNode(BiLinkList biLinkList) {
        biLinkList.next.prev = biLinkList.prev;
        biLinkList.prev.next = biLinkList.next;
    }

    /**
     * 在headNode 之后添加节点
     * @param headNode
     * @param addNode
     */
    private void addNode(BiLinkList headNode, BiLinkList addNode) {
        headNode.next.prev = addNode;
        addNode.next = headNode.next;
        addNode.prev = headNode;
        headNode.next = addNode;
    }
}
