package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode01
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 17:01
 * @Version 1.0
 */
public class LeetCode01 {

    @Test
    public void test() {
        int[] nums = {3,2,4};
        System.out.println(twoSum(nums, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)) {
                if (temp == nums[i] && map.get(temp) == i) {
                    continue;
                }
                return new int[] {i, map.get(temp)};
            }
        }
        return new int[]{};
    }
}
