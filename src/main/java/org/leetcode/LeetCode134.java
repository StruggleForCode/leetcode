package org.leetcode;

/**
 * ClassName: LeetCode134
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/13 14:34
 * @Version 1.0
 */
public class LeetCode134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        canCompleteCircuit(gas, cost);
    }

    /**
     * 居然不是动态规划，是贪心。。
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] nums = new int[gas.length];
        int length = gas.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = gas[i] - cost[i];
        }
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        suffix[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] += suffix[i + 1] + nums[i];
        }
        if (prefix[length - 1] < 0 && suffix[0] < 0) {
            return -1;
        }
        int res = length - 1;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] < 0)
                continue;
            if (suffix[i] < 0)
                continue;
            int tmp = suffix[i] + prefix[i - 1];
            if (tmp >= 0) {
                res = i;
            }
        }
        return res;
    }

}

/*
gas = [1,2,3,4,5],
cost = [3,4,5,1,2]
[1,2,3,4,5]
[3,4,5,1,2]
[-2, -2, -2, 3, 3]

[-2, -4, -6, -3, 0]

[0,   2,  4,  6, 3]

 */
