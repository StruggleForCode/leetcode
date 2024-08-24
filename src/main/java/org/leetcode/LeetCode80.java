package org.leetcode;

/**
 * ClassName: LeetCode80
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/8/24 12:35
 * @Version 1.0
 */
public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int left = 1;
        int right = 2;
        while (right < nums.length) {
            if ((nums[right] != nums[left]) || (nums[left] != nums[left - 1])) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}
