package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ClassName: LeetCode169
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/8/24 14:33
 * @Version 1.0
 */
public class LeetCode169 {

    @Test
    public void test() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums2 = {3, 1, 3};
        int[] nums3 = {3, 3, 4};
        System.out.println(majorityElement(nums3));
    }

    /**
     * 自己都随机化失败
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int cur = nums[random.nextInt(nums.length)];
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        int maxValue = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > maxValue) {
                result = key;
                maxValue = value;
            }
        }
        return result;
    }


    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 随机化更有准确性
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}
