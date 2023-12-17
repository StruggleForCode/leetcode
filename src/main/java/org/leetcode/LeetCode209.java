package org.leetcode;

/**
 * ClassName: LeetCode209
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/17 20:17
 * @Version 1.0
 */
public class LeetCode209 {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int[] nums2 = {2,3,1,2,4,3};
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(4, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < target) {
            return 0;
        }
        sum = nums[right];
        while (right <= nums.length) {
            if (sum >= target) {
                minLength = Math.min(minLength, right - left +  1);
                sum -= nums[left];
                left++;
            } else {
                right++;
                if (right == nums.length) break;
                sum += nums[right];
            }
        }
        while (sum >= target && left < right - 1) {
            minLength = Math.min(minLength, right - left + 1);
            sum = nums[left];
            left++;
        }
        return minLength;
    }
}
