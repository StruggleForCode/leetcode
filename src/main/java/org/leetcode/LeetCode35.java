package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode35
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/4 21:43
 * @Version 1.0
 */
public class LeetCode35 {

    @Test
    public void test() {
        int[] nums = {1, 3};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
