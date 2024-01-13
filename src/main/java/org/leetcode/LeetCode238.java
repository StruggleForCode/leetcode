package org.leetcode;

/**
 * ClassName: LeetCode238
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/13 14:08
 * @Version 1.0
 */
public class LeetCode238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] prefixNum = new int[nums.length];
        int[] suffixNum = new int[nums.length];
        prefixNum[0] = nums[0];
        suffixNum[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefixNum[i] = prefixNum[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixNum[i] = suffixNum[i + 1] * nums[i];
        }
        nums[0] = suffixNum[1];
        nums[nums.length - 1] = prefixNum[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = prefixNum[i - 1] * suffixNum[i + 1];
        }
        return nums;
    }
}

/*
nums = [2,2,3,4]
输出: [24,24,16,12]

前缀积、后缀积
[2, 4, 12, 48]
[48,24, 12, 4]
 */
