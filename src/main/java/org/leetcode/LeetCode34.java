package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode34
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/12 22:52
 * @Version 1.0
 */
public class LeetCode34 {
    // 两次二分，1.查找第一个比目标值大的数的位置 2.查找第一个比目标值小的数的位置
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int targetRight = binaryMoreTarget(nums, target);
        int targetLeft = binaryLessTarget(nums, target);
        if (targetRight <= targetLeft) {
            return new int[] {-1, -1};
        }
        res[0] = targetLeft;
        res[1] = targetRight - 1;
        return res;
    }

    @Test
    public void test() {
        int[] nums = {5, 6, 7, 7, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 7);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int binaryMoreTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binaryLessTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
