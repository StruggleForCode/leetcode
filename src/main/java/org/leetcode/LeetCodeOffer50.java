package org.leetcode;

import java.util.Arrays;

public class LeetCodeOffer50 {
    public char firstUniqChar(String s) {
        int[] num = new int[26];
        for (int i = 0; i < num.length; i++) {
            num[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            num[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (num[ch - 'a'] == 1){
                return ch;
            }
        }
        return ' ';
    }
}
