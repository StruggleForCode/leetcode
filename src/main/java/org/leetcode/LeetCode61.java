package org.leetcode;

/**
 * ClassName: LeetCode61
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/5 19:30
 * @Version 1.0
 */
public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int listSize = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            listSize++;
            ptr = ptr.next;
        }
        k = k % listSize;
        if (k == 0) {
            return head;
        }
        k = listSize - k;
        ListNode firstNode = head;
        while (k > 1) {
            firstNode = firstNode.next;
            k--;
        }
        ListNode tmp = head;
        head = firstNode.next;
        firstNode.next = null;
        ptr.next = tmp;
        return  head;
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
