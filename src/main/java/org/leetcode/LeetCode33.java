package org.leetcode;

/**
 * ClassName: LeetCode33
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/7 22:57
 * @Version 1.0
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // 左半部分有序
                if (target < nums[mid] && target >= nums[0]) {
                    right = mid - 1; // 如果在左半部分，缩小右边界
                } else {
                    left = mid + 1;  // 如果在右半部分，缩小左边界
                }
            } else { // 左半部分无序， 右半部分有序
                if (target > nums[mid] && target <= nums[length-1]) {
                    left = mid + 1;   // 在右半部分，缩小左边界
                } else {
                    right = mid - 1;  // 在左半部分，缩小有边界
                }
            }
        }
        return -1;
    }
}
