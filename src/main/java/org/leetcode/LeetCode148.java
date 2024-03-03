package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LeetCode148
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 15:17
 * @Version 1.0
 */
public class LeetCode148 {

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(1, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode listNode = sortList(listNode4);
        System.out.println(listNode);
    }

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) return null;
        ListNode ptr = head;
        while (ptr != null) {
            list.add(ptr);
            ptr = ptr.next;
        }

        merge(list, 0, list.size());
        head = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i+1);
        }
        return head;
    }

    public void merge(List<ListNode> list, int left, int right) {
        if (left >= right) {
            return;
        }
        if (left == right - 1) {
            if (list.get(left).val > list.get(right).val) {
                ListNode temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
            }
            return;
        }
        int mid = (left + right) / 2;
        merge(list, left, mid);
        merge(list, mid + 1, right);
        List<ListNode> temp = new ArrayList<>();
        int begin1 = left;
        int begin2 = mid + 1;
        int end1 = mid;
        int end2 = right;
        while((begin1 < end1) && (begin2 < end2)) {
            if (list.get(begin1).val < list.get(begin2).val) {
                temp.add(list.get(begin1));
                begin1++;
            } else {
                temp.add(list.get(begin2));
                begin2++;
            }
        }
        while (begin1 < end1) {
            temp.add(list.get(begin1));
            begin1++;
        }
        while (begin2 < end2) {
            temp.add(list.get(begin2));
            begin2++;
        }
        for (int i = left, j = 0; i <= right &&j < temp.size(); i++, j++) {
            list.set(i, temp.get(j));
        }
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
