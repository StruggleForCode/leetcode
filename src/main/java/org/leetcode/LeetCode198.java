package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode198
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/4/6 14:57
 * @Version 1.0
 */
public class LeetCode198 {

    @Test
    public void test() {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int lastNum = nums[nums.length - 1];
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 2] + nums[i];
        }
        int res = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        if (nums.length % 2 == 0) {
            res = Math.max(res, nums[0] + lastNum);
        }
        return res;
    }
}
