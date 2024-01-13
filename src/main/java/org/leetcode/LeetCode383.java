package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode383
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/24 17:06
 * @Version 1.0
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote. length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character character = magazine.charAt(i);
            magazineMap.put(character, magazineMap.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (magazineMap.containsKey(ch) && magazineMap.get(ch) > 0) {
                magazineMap.put(ch, magazineMap.get(ch) - 1);
            } else{
                return false;
            }
        }
        return true;
    }
}
