package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode76
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/23 13:39
 * @Version 1.0
 */
public class LeetCode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        String ret  = s;
        int left = 0;
        int right = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int size = t.length();
        while (left < s.length()) {
            if (size == 0) {
                String substring = s.substring(left, right);
                if (substring.length() < ret.length()) {
                    ret = substring;
                }
                Character ch = s.charAt(left);
                if (map.containsKey(ch) & map.get(ch) <= 0) {
                    map.put(ch, map.get(ch) + 1);
                    size++;
                }
                left++;
            } else {
                if (right >= s.length()) continue;
                Character ch = s.charAt(right);
                if (map.containsKey(ch) && map.get(ch) > 0) {
                    map.put(ch, map.get(ch) - 1);
                    size--;
                }
                right++;
            }
        }
        return ret;
    }
}

/*
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */
