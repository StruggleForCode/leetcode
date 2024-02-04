package org.leetcode;

/**
 * ClassName: LeetCode19
 * Package: org.leetcode
 * Description: 中等题，感觉很简单。考研的时候见过类似题目
 *
 * @Author LeeHao
 * @Create 2024/2/4 22:24
 * @Version 1.0
 */
public class LeetCode19 {

    /**
     * 思路：
     * 两个指针，第一个指针先走n + 1步，然后另一个指针，从起点一起走，第一个指针走到头。
     * 删除的就是第二个指针指向的节点的下一个节点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        // 先让right 走n+1步
        // for循环先让走N步。
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        // 如果第n个节点的下一步为null, 则删除的第一个节点。否则在走一步，走到N+1步
        if (right == null) {
            return head.next;
        } else {
            right = right.next;
        }
        ListNode left = head;
        while (right != null) {
            // 两个指针一起走
            right = right.next;
            left = left.next;
        }
        // 删除第N个节点
        left.next = left.next.next;
        return head;
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
