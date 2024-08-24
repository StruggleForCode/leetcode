package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode70
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/4/6 14:24
 * @Version 1.0
 */
public class LeetCode70 {

    @Test
    public void test() {
        System.out.println(climbStairs(3));
    }

    public int climbStairs(int n) {
        // 方程d(n) = d(n-1) + d(n-2);
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
