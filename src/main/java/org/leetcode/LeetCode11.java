package org.leetcode;

/**
 * ClassName: leetcode11
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/16 18:26
 * @Version 1.0
 */
public class LeetCode11 {
    public static void main(String[] args) {
        int[] height = {1,3,2,5,25,24,5};
        int res = maxArea(height);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        int index1 = 0;
        int index2 = height.length - 1;
        int max = 0;
        while (index1 < index2) {
            int volume = (index2 - index1) * Math.min(height[index1], height[index2]);
            if (volume > max) {
                max = volume;
            }
            if (height[index1] < height[index2]) {
                index1++;
            } else {
                index2--;
            }
        }
        return max;
    }

}
