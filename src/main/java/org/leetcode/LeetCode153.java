package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode153
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/13 22:38
 * @Version 1.0
 */
public class LeetCode153 {
    @Test
    public void test() {
        int[] nums = {3, 4, 5,  1, 2};
        System.out.println(findMin(nums));
    }


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
