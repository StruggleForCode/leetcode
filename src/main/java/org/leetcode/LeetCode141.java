package org.leetcode;

/**
 * ClassName: LeetCode141
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/3 20:49
 * @Version 1.0
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        if (first == null) return false;
        while(first.next != null) {

            first = first.next.next;
            second = second.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
