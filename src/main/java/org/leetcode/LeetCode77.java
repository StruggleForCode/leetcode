package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: LeetCode77
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/1 22:15
 * @Version 1.0
 */
public class LeetCode77 {

    @Test
    void test() {
        List<List<Integer>> res = combine(4, 2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, n, k, 0, 1, temp);
        return res;
    }

    public void dfs(List<List<Integer>> res, int n, int k, int index, int next, List<Integer> temp) {
        if (index == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                list.add(temp.get(i));
            }
            res.add(list);
            return;
        }
        for (int i = next; i <= n; i++) {
            temp.add(i);
            dfs(res, n, k, index + 1, i + 1, temp);
            temp.remove(index);
        }
    }

    // 剪支版本
    public void dfs2(List<List<Integer>> res, int n, int k, int index, int next, List<Integer> temp) {
        if (k - index > n - next + 1) {
            return;
        }
        if (index == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = next; i <= n; i++) {
            temp.add(i);
            dfs(res, n, k, index + 1, i + 1, temp);
            temp.remove(index);
        }
    }

}
