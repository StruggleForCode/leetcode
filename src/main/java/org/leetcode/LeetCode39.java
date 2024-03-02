package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: LeetCode39
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/2 23:25
 * @Version 1.0
 */
public class LeetCode39 {

    @Test
    public void test() {
        int[] candidates = {3, 5, 1};
        List<List<Integer>> res = combinationSum(candidates, 8);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, target,0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] candidates, int target, int curSum, int index, List<Integer> temp) {
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int cnt = (target - curSum) / candidates[i];
            for (int j = 1; j <= cnt; j++) {
                for (int k = 1; k <= j; k++) {
                    temp.add(candidates[i]);
                    curSum += candidates[i];
                }
                dfs(res, candidates, target, curSum, i + 1, temp);
                for (int k = 1; k <= j; k++) {
                    temp.remove(temp.size() - 1);
                    curSum -= candidates[i];
                }
            }
        }
    }
}

/**
 * [3, 5]
 * [3, 1, 1, 1, 1, 1]
 * [3, 1, 1, 1, 1, 1]
 * [3, 1, 1, 1, 1, 1]
 * [3, 1, 1, 1, 1, 1]
 * [3, 1, 1, 1, 1, 1]
 */
