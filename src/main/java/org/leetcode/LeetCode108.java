package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ClassName: LeetCode108
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 14:49
 * @Version 1.0
 */
public class LeetCode108 {

    @Test
    public void test() {
        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int length = nums.length;
        int mid = length / 2;
        TreeNode leftTreeNode = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        TreeNode rightTreeNode = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, length));
        return new TreeNode(nums[mid], leftTreeNode, rightTreeNode);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
