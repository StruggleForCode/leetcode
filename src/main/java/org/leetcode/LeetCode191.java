package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode191
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/27 22:43
 * @Version 1.0
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n & 1;
            n = n >> 1;
        }
        return ans;
    }

    @Test
    void test() {
        System.out.println(hammingWeight(11));
    }
}
