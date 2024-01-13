package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode242
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/24 17:56
 * @Version 1.0
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    map.put(ch, map.get(ch) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
