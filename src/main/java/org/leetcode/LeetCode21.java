package org.leetcode;

/**
 * ClassName: LeetCode21
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/3 20:55
 * @Version 1.0
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res;
        if (list1.val < list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        ListNode ptr = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                ptr = ptr.next;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                ptr = ptr.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            ptr.next = list1;
        } else if (list2 != null) {
            ptr.next = list2;
        }
        return res;
    }


    class ListNode {
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
