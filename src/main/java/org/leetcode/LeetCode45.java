package org.leetcode;

/**
 * ClassName: LeetCode45
 * Package: org.leetcode
 * Description:
 *
 * https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
 *
 * @Author LeeHao
 * @Create 2023/12/9 14:53
 * @Version 1.0
 */
public class LeetCode45 {

    public static void main(String[] args) {
       int[] nums1 = {2,3,1,1,4};
       int[] nums2 = {2,3,0,1,4};
        System.out.println(jump(nums2));
    }

    public static int jump(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0x3fffffff;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            for (; j <= (i + nums[i]) && j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
            if (j == dp.length) break;
        }
        return dp[nums.length - 1];
    }



}

/*
0x3f
dp[i]记录 到第i个位置，最小的跳跃数。

dp[i] = 能到当前位置到最小跳数 + 1；

dp[i] 初始化为无穷大

dp[0] = 1;



dp[i] = dp[i - 1]

 */