package org.leetcode;

/**
 * ClassName: LeetCode136
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/27 22:48
 * @Version 1.0
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0 ; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }


}
