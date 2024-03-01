package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: LeetCode17
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/1 21:53
 * @Version 1.0
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res= new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        dfs(res, digits, map, 0, "");
        return res;
    }

    public void dfs(List<String> res, String digits, Map<Integer, String> map, int index,  String temp) {
        if (index == digits.length()) {
            res.add(temp);
            return;
        }
        String cur = map.get(digits.charAt(index) - '0');
        for (int i = 0; i < cur.length(); i++) {
            dfs(res, digits, map, index + 1, temp + cur.charAt(i));
        }
    }
}
