package org.leetcode;

import java.util.List;

/**
 * ClassName: LeetCode86
 * Package: org.leetcode
 * Description: 闭着眼睛瞎写，一次过
 *
 * @Author LeeHao
 * @Create 2024/2/5 19:49
 * @Version 1.0
 */
public class LeetCode86 {
    /**
     * 定义两个哑节点， 一个是小于x dummyMin, 一个是大于x dummyMax。对于小于x的节点挂在dummyMin上，对于大于x的节点，挂在dummyMax上
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyMin = new ListNode(x -1, head);
        ListNode dummyMax = new ListNode(x + 1, head);
        ListNode minNode = dummyMin;
        ListNode maxNode = dummyMax;
        ListNode curPtr = head;
        while (curPtr != null) {
            int curVal = curPtr.val;
            if (curVal < x) {
                minNode.next = curPtr;
                minNode = curPtr;
                curPtr = curPtr.next;
            } else {
                maxNode.next = curPtr;
                maxNode = curPtr;
                curPtr = curPtr.next;
            }
        }
        maxNode.next = null;
        minNode.next = dummyMax.next;
        return dummyMin.next;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
