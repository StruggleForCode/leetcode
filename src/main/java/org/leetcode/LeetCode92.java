package org.leetcode;

/**
 * ClassName: LeetCode92
 * Package: org.leetcode
 * Description: 好家伙，缝缝补补居然过了， 对 left = 1需要特殊判断。 想出来的也是官方的头插法，但是自己多定义了一个变量，麻烦了。
 *
 * @Author LeeHao
 * @Create 2024/2/3 22:28
 * @Version 1.0
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        // 用于记录调换位置left位置前的上一个节点
        ListNode leftPtr = head;
        for (int i = 1; i < left - 1; i++) {
            leftPtr = leftPtr.next;
        }
        // 这一块有点点绕
        ListNode curPtr;
        // 单独判断left为1的情况, curPtr为多少
        if (left != 1) {
            curPtr = leftPtr.next;
        } else {
            curPtr = leftPtr;
        }
        ListNode nextPtr = curPtr.next;
        curPtr.next = null;
        ListNode nextNextPtr = null;
        if (nextPtr != null){
            nextNextPtr= nextPtr.next;
        }
        for (int i = left; i < right; i++) {
            if (nextPtr != null) nextPtr.next = curPtr;
            else break;
            curPtr = nextPtr;
            nextPtr = nextNextPtr;
            if (nextNextPtr != null) nextNextPtr = nextNextPtr.next;
            else break;
        }
        if (leftPtr.next != null) {
            leftPtr.next.next = nextPtr;
            leftPtr.next = curPtr;
        }
        if (left != 1)
         return head;
        else return curPtr;
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
