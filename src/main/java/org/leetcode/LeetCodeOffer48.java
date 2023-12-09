package org.leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeOffer48 {
    public static void main(String[] args) {
        int res = lengthOfLongestSubstring(" ");
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        // int 记录下标
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                map.put(ch, right);
            } else {
                int tmp = map.get(ch);
                while (left <= tmp) {
                    map.remove(s.charAt(left));
                    left++;
                }
                map.put(ch, right);
            }
            right++;
            if (result < right - left) {
                result = right - left;
            }
        }
        return result;
    }
}

/*
abcdefgchigklm
map.
 */