package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode290
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/24 17:45
 * @Version 1.0
 */
public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        Map<Character, String> map_pattern = new HashMap<>();
        Map<String, Character> map_s = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            String tmp = strings[i];
            if (map_pattern.containsKey(ch) && map_s.containsKey(tmp)) {
                if (!map_pattern.get(ch).equals(tmp)) {
                    return false;
                }
            } else if ((map_pattern.containsKey(ch) && !map_s.containsKey(tmp)) ||
                    (!map_pattern.containsKey(ch) && map_s.containsKey(tmp))) {
                return false;
            } else {
                map_pattern.put(ch, tmp);
                map_s.put(tmp, ch);
            }
        }
        return true;
    }
}
