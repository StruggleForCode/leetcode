package org.leetcode;

/**
 * ClassName: LeetCode88
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 16:04
 * @Version 1.0
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m];
                m--;
            } else {
                nums1[index--] = nums2[n];
                n--;
            }
        }
        while (m >= 0) {
            nums1[index--] = nums1[m];
            m--;
        }
        while (n >= 0) {
            nums1[index--] = nums2[n];
            n--;
        }
    }
}
