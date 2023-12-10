package org.leetcode;

/**
 * ClassName: LeetCode55
 * Package: org.leetcode
 * Description: 跳跃游戏
 * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @Author LeeHao
 * @Create 2023/12/9 13:21
 * @Version 1.0
 */
public class LeetCode55 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length <= 0 || nums == null) {
            return false;
        }
        if (nums[0] == 0 && nums.length > 1) {
            return false;
        }
        boolean flag = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] >= (i - j)) {
                        i = j;
                        break;
                    }
                    if (j == 0) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }
}

// 3,2,1,0,4
// 0 1 2 3 4
// 2 0 0

