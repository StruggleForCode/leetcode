package org.leetcode;

/**
 * ClassName: LeetCode82
 * Package: org.leetcode
 * Description: 自己没有用哑节点，用哑节点其实更方便。
 *
 * @Author LeeHao
 * @Create 2024/2/4 22:44
 * @Version 1.0
 */
public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode curPtr = head;
        ListNode nextPtr =head.next;
        // 对于只有一个节点的特殊处理
        if (nextPtr == null) return head;
        ListNode lastPtr = null;
        while (nextPtr != null) {
            if (nextPtr.val != curPtr.val) {
                lastPtr = curPtr;
                curPtr = nextPtr;
                nextPtr = nextPtr.next;
            } else {
                // 如果第一个有重复，对第一个进行特殊处理
                if (lastPtr == null) {
                    int val = head.val;
                    while (head.val == val) {
                        head = head.next;
                        // 对于第一个都一样的，特殊处理
                        if (head == null) return head;
                    }
                    curPtr = head;
                    nextPtr = head.next;
                    continue;
                }
                // 如果对第一个没有重复，则不进行特殊处理，进行以下处理
                int val = curPtr.val;
                while (curPtr.val == val) {
                    curPtr = curPtr.next;
                    lastPtr.next = curPtr;
                    if (curPtr == null) return head;
                }
                nextPtr = curPtr.next;
            }
        }
        // 对第一个特殊处理
        if (lastPtr == null && head.next != null) {
            head = head.next;
        }
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
