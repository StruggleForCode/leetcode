package org.leetcode;

import java.util.*;

/**
 * ClassName: LeetCode15
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/16 19:27
 * @Version 1.0
 */
public class LeetCode15 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        int[] nums2 = {-1,-1,-1,0, 0, 0, 0, 1, 1, 1};
        List<List<Integer>> lists = threeSum(nums2);
        System.out.println(lists.toString());
    }

    /**
     * 这个题有点过于离谱
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        Set<String> ans = new HashSet<>();
        while (left < nums.length - 2) {
            if (right >= nums.length) {
                left++;
                right = left + 1;
                continue;
            }
            int target = -(nums[left] + nums[right]);
            if (target < nums[right]) {
                left++;
                right = left + 1;
                continue;
            }
            if (find(nums, right + 1,  nums.length - 1, target)) {
                String s = Integer.toString(nums[left]) + Integer.toString(nums[right]) + Integer.toString(target);
                if (ans.contains(s)) {
                    right++;
                    continue;
                }
                ans.add(s);
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                list.add(target);
                res.add(list);
            }
           right++;
        }
        return res;
    }

    public static boolean find(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                return true;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}

/*
-1,0,1,2,-1,-4

-4 -1 -1 0 1 2

-2 0 1 1 2
 */