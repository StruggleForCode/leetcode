package org.leetcode;

/**
 * ClassName: LeetCode167
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/16 18:11
 * @Version 1.0
 */
public class LeetCode167 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 15};
        int target = 6;
        int[] res = twoSum(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            int sum = numbers[index1] + numbers[index2];
            if (sum > target) {
                index2--;
            }
            if (sum < target) {
                index1++;
            }
            if (sum == target) break;
        }
        if (index1 >= index2) return null;
        int[] res = {index1 + 1, index2 + 1};
        return res;
    }

}
