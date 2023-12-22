package org.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LeetCode03
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/22 20:03
 * @Version 1.0
 */
public class LeetCode03 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
             return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length() && left <= right) {
            char ch = s.charAt(right);
            if (set.contains(ch)) {
                while (s.charAt(left) != ch && left <= right) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(ch);
            right++;
            if (right - left > max) {
                max = right -left;
            }
        }
        return max;
    }
}

/*
s = "abcabcbb
 */
