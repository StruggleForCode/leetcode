package org.leetcode;

/**
 * ClassName: LeetCode137
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/4/4 17:32
 * @Version 1.0
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int j = 0; j < nums.length; j++) {
                total += nums[j] % 2;
                nums[j] >>= 1;
            }
            if (total % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
