package org.leetcode;

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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
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
            int cnt = target / candidates[i];
            for (int j = 1; j <= cnt; j++) {
                for (int k = 1; k <= j; k++) {
                    temp.add(candidates[i]);
                    curSum += candidates[i];
                }
                dfs(res, candidates, target, curSum, index + 1, temp);
                for (int k = 1; k <= j; k++) {
                    temp.remove(temp.size() - 1);
                    curSum -= candidates[i];
                }
            }
        }
    }
}
