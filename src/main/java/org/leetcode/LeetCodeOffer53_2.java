package org.leetcode;

public class LeetCodeOffer53_2 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else if (nums[mid] == mid) {
                left = mid + 1;
            }
        }
        return left;
    }
}
