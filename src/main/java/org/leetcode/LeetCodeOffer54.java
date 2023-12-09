package org.leetcode;

import java.util.ArrayList;

public class LeetCodeOffer54 {
    public static void main(String[] args) {

    }
    int cnt = 0;
    int key;
    public int kthLargest(TreeNode root, int k) {
        findNode(root, k);
        return key;
    }
    public void findNode(TreeNode root, int k) {
        if (cnt == k) {
            return;
        }
        if (root != null) {
            findNode(root.right, k);
            cnt++;
            if(cnt == k) {
                key = root.val;
            }
            findNode(root.left, k);
        }
    }


}
