package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode26
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/8/24 12:20
 * @Version 1.0
 */
public class LeetCode26 {


    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}
