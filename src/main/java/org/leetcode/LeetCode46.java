package org.leetcode;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LeetCode46
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/2 21:11
 * @Version 1.0
 */
public class LeetCode46 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute(nums);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int index, List<Integer> temp, boolean[] used) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(res, nums, index + 1, temp, used);
                temp.remove(temp.size() - 1);
                used[i]=false;
            }

        }
    }
}
