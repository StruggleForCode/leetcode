package org.leetcode;

public class LeetCodeOffer53_1 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search(nums, 8));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = left - 1;
        int index = left;
        int count = 0;
        while (index >= 0 && nums[index] == target) {
            index--;
            count++;
        }
        index = left + 1;
        while (index <= nums.length - 1 && nums[index] == target) {
            index++;
            count++;
        }
        return count;
    }


}
