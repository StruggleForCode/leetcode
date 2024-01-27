package org.leetcode;

import java.util.*;

/**
 * ClassName: LeetCode49
 * Package: org.leetcode
 * Description:字母异位词分组
 *
 * @Author LeeHao
 * @Create 2024/1/27 21:26
 * @Version 1.0
 */
public class LeetCode49 {
    public static void main(String[] args) {

    }

    /**
     * 思路：先给每一个字符串排序，从小到大，所有字母异位词的最终单词顺序是一样的。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String str = String.copyValueOf(tmp);
            if (hashMap.containsKey(str)) {
                List<String> list = hashMap.get(str);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(str, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
