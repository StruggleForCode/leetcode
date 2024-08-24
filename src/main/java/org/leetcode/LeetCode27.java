package org.leetcode;

/**
 * ClassName: LeetCode27
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/8/24 11:55
 * @Version 1.0
 */
public class LeetCode27 {
    /**
     * 用到了双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                left++;
                res++;
            } else {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    nums[right] = val;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
