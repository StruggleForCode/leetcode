package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode205
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/24 17:15
 * @Version 1.0
 */
public class LeetCode205 {
    public static void main(String[] args) {
        String s1 = "paper";
        String s2 = "title";
        System.out.println(isIsomorphic(s1, s2));
    }
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map_s = new HashMap<>();
        Map<Character, Character> map_t = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);
            if (map_s.containsKey(s_ch) && map_t.containsKey(t_ch)) {
                if (map_s.get(s_ch) != t_ch) return false;
            } else if ((map_s.containsKey(s_ch) && !map_t.containsKey(t_ch)) || (!map_s.containsKey(s_ch) && map_t.containsKey(t_ch))) {
                return false;
            } else {
                map_s.put(s_ch, t_ch);
                map_t.put(t_ch, s_ch);
            }
        }
        return true;
    }
}
