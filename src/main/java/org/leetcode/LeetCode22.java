package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LeetCode22
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 12:44
 * @Version 1.0
 */
public class LeetCode22 {

    @Test
    public void test() {
        List<String> list = generateParenthesis(8);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    public void dfs(List<String> res, int left, int right,String temp) {
        if (left == 0 && right == 0) {
            res.add(temp);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(res, left - 1, right, temp + "(");
        }
        if (right > 0) {
            dfs(res, left, right - 1, temp + ")");
        }
    }
}
