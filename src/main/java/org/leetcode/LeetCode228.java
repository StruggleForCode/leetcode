package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LeetCode228
 * Package: org.leetcode
 * Description: 汇总区间 简单
 *
 * @Author LeeHao
 * @Create 2024/1/29 23:29
 * @Version 1.0
 */
public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        int begin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                String str;
                if (begin != nums[i - 1]) {
                    str = String.valueOf(begin) + "->" + String.valueOf(nums[i - 1]);
                } else {
                    str = String.valueOf(begin);
                }
                ret.add(str);
                begin = nums[i];
            }
        }
        String str;
        if (begin != nums[nums.length - 1]) {
            str = String.valueOf(begin) + "->" + String.valueOf(nums[nums.length - 1]);
        } else {
            str = String.valueOf(begin);
        }
        ret.add(str);
        return ret;
    }
}
