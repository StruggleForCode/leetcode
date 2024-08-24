package org.leetcode;

/**
 * ClassName: LeetCode33
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/7 22:57
 * @Version 1.0
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;

        }
        return 0;
    }
}
